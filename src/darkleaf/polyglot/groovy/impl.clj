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
                                Phases)))

(set! *warn-on-reflection* true)

(defn compiler-configuration [named-resource]
  (let [cc     (CompilerConfiguration.)
        config (-> named-resource io/resource slurp)]
    (GroovyMain/processConfigScriptText config cc)
    cc))

(def default-compiler-configuration
  (compiler-configuration "darkleaf/polyglot/groovy/config.groovy"))

(defn- add-source [^CompilationUnit unit full-name]
  (let [url (.. unit getClassLoader getResourceLoader (loadGroovySource full-name))]
    (.addSource unit url)))

(defn- class-gen ^CompilationUnit$ClassgenCallback []
  (reify CompilationUnit$ClassgenCallback
    (call [_ writer node]
      (let [writer        ^ClassWriter writer
            bytecode      (.toByteArray writer)
            name          (.getName node)
            loader        ^DynamicClassLoader @Compiler/LOADER
            compiledClass (.defineClass loader name bytecode nil)]))))

(defn -compile [full-name opts]
  (let [compiler-configuration
        ^CompilerConfiguration
        (get opts
             :compiler-configuration
             default-compiler-configuration)]
    (doto (CompilationUnit. compiler-configuration)
      (add-source full-name)
      (.setClassNodeResolver (DynamicClassNodeResolver.))
      (.setClassgenCallback (class-gen))
      (.compile Phases/CLASS_GENERATION))))

(defn -name->class-name [ns name]
  (let [ns-part (namespace-munge ns)
        name    (munge name)]
    (symbol (str ns-part "." name))))

(defn -instantiate [name classname]
 `(def ~name (new ~classname)))

(defn -defclass* [name opts]
  `(-compile ~(str name) ~opts))
