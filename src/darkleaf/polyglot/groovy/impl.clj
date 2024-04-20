(ns darkleaf.polyglot.groovy.impl
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str])
  (:import
   (darkleaf.polyglot.groovy DynamicClassNodeResolver)
   (clojure.lang RT Compiler DynamicClassLoader)
   (groovy.lang GroovyResourceLoader)
   (groovy.ui GroovyMain)
   (groovyjarjarasm.asm ClassWriter)
   (org.codehaus.groovy.control CompilerConfiguration
                                CompilationUnit
                                CompilationUnit$ClassgenCallback
                                SourceUnit
                                Phases)))

(set! *warn-on-reflection* true)

(defn- compiler-configuration ^CompilerConfiguration [named-resource]
  (let [cc     (CompilerConfiguration.)
        config (-> named-resource io/resource slurp)]
    (GroovyMain/processConfigScriptText config cc)
    cc))

(defn- add-source ^SourceUnit [^CompilationUnit unit full-name]
  (when-some [url (.. unit getClassLoader getResourceLoader (loadGroovySource full-name))]
    (.addSource unit url)))

(defn- class-gen ^CompilationUnit$ClassgenCallback []
  (reify CompilationUnit$ClassgenCallback
    (call [_ writer node]
      (let [writer        ^ClassWriter writer
            bytecode      (.toByteArray writer)
            name          (.getName node)
            loader        ^DynamicClassLoader @Compiler/LOADER
            compiledClass (.defineClass loader name bytecode nil)]))))

(defn- check-main-class! [^SourceUnit su expected]
  (let [actual (.. su getAST getMainClassName)]
    (if (not= expected actual)
      (throw (ex-info "Wrong main class" {:expected expected
                                          :actual   actual})))))

(defn -compile [full-name]
  (let [full-name (str full-name)
        cc        (doto (compiler-configuration "darkleaf/polyglot/groovy/config.groovy")
                    (.setTargetDirectory (io/file *compile-path*)))
        unit      (doto (CompilationUnit. cc)
                    (.setClassNodeResolver (DynamicClassNodeResolver.))
                    (.setClassgenCallback (class-gen)))
        su        (add-source unit full-name)]
    (cond
      ;; a source code is preferable to a compiled class
      (some? su)
      (do
        (.compile unit Phases/CONVERSION)
        (check-main-class! su full-name)
        (.compile unit Phases/CLASS_GENERATION)
        (if *compile-files*
          (.compile unit Phases/OUTPUT)))

      ;; already compiled one
      (some? (RT/loadClassForName full-name))
      nil

      :else
      (throw
       (ex-info (str "Could not find a groovy file or a compiled one for " full-name)
                {:full-name full-name})))))

(defn -name->class-name [ns name]
  (let [ns-part (namespace-munge ns)
        name    (munge name)]
    (symbol (str ns-part "." name))))

(defn -instantiate [name classname]
 `(def ~name (new ~classname)))
