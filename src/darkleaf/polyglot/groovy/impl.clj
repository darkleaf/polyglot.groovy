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
                                Phases)
   (org.codehaus.groovy.runtime InvokerHelper)))

(set! *warn-on-reflection* true)

(defn compiler-configuration [named-resource]
  (let [cc     (CompilerConfiguration.)
        config (-> named-resource io/resource slurp)]
    (GroovyMain/processConfigScriptText config cc)
    cc))

(def default-compiler-configuration
  (compiler-configuration "darkleaf/polyglot/groovy/config.groovy"))

(defn -compile [full-name opts]
  (let [compiler-configuration
        ^CompilerConfiguration
        (get opts
             :compiler-configuration
             default-compiler-configuration)

        unit      (CompilationUnit. compiler-configuration)
        _         (.setClassNodeResolver unit (DynamicClassNodeResolver.))
        url       (.. unit getClassLoader getResourceLoader (loadGroovySource full-name))
        su        (.addSource unit url)
        cb        (reify CompilationUnit$ClassgenCallback
                    (call [_ writer node]
                      (let [writer        ^ClassWriter writer
                            bytecode      (.toByteArray writer)
                            name          (.getName node)
                            loader        ^DynamicClassLoader @Compiler/LOADER
                            compiledClass (.defineClass loader name bytecode nil)])))
        _         (.setClassgenCallback unit cb)
        goalPhase Phases/CLASS_GENERATION
        _         (.compile unit goalPhase)]))

(defn -name->class-name [ns name]
  (let [ns-part (namespace-munge ns)
        name    (munge name)]
    (symbol (str ns-part "." name))))

;; todo: arglists
;; todo?: remove reflection
(defn -constructor [name classname]
  (let [cname  (symbol (str "->" name))
        params (with-meta '[& args]
                 {:tag classname})]
    `(defn ~cname ~params
       (InvokerHelper/invokeConstructorOf ~classname (object-array ~'args)))))

(defn -instantiate [name classname]
  `(def ~name (new ~classname)))

(defn -defclass* [name opts]
  `(-compile ~(str name) ~opts))
