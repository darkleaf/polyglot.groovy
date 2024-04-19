(ns darkleaf.polyglot.groovy.impl
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str])
  (:import
   (darkleaf.polyglot.groovy DynamicClassNodeResolver)
   (clojure.lang Compiler DynamicClassLoader)
   (groovy.lang GroovyResourceLoader)
   (groovy.ui GroovyMain)
   (groovyjarjarasm.asm ClassWriter)
   (org.codehaus.groovy.control CompilerConfiguration
                                CompilationUnit
                                CompilationUnit$ClassgenCallback
                                SourceUnit
                                Phases)))

(set! *warn-on-reflection* true)

(defn- compiler-configuration [named-resource]
  (let [cc     (CompilerConfiguration.)
        config (-> named-resource io/resource slurp)]
    (GroovyMain/processConfigScriptText config cc)
    cc))

(def ^:private ^CompilerConfiguration default-compiler-configuration
  (compiler-configuration "darkleaf/polyglot/groovy/config.groovy"))

(defn- add-source ^SourceUnit [^CompilationUnit unit full-name]
  (let [url (.. unit getClassLoader getResourceLoader (loadGroovySource full-name))]
    (if (nil? url)
      (throw (ex-info (str "Could not find a groovy file for " full-name)
                      {:full-name full-name})))
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
        unit      (doto (CompilationUnit. default-compiler-configuration)
                    (.setClassNodeResolver (DynamicClassNodeResolver.))
                    (.setClassgenCallback (class-gen)))
        su        (add-source unit full-name)]
    (.compile unit Phases/CONVERSION)
    (check-main-class! su full-name)
    (.compile unit Phases/CLASS_GENERATION)))

(defn -name->class-name [ns name]
  (let [ns-part (namespace-munge ns)
        name    (munge name)]
    (symbol (str ns-part "." name))))

(defn -instantiate [name classname]
 `(def ~name (new ~classname)))
