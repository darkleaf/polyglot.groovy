(ns darkleaf.clj-groovy.impl
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str])
  (:import
   (java.net URL)
   (clojure.lang Compiler DynamicClassLoader)
   (org.codehaus.groovy.runtime InvokerHelper)
   (org.codehaus.groovy.control CompilerConfiguration
                                CompilationUnit
                                CompilationUnit$ClassgenCallback
                                Phases)
   (groovy.ui GroovyMain)
   (groovyjarjarasm.asm ClassWriter)))

(set! *warn-on-reflection* true)

(defn compiler-configuration [named-resource]
  (let [cc     (CompilerConfiguration.)
        config (-> named-resource io/resource slurp)]
    (GroovyMain/processConfigScriptText config cc)
    cc))

(def default-compiler-configuration
  (compiler-configuration "darkleaf/clj_groovy/config.groovy"))

(def ^:private extensions
  [".groovy" #_".sgroovy"])

(defn- url ^URL [full-name]
  (let [full-name (str/replace full-name \. \/)]
    (->> extensions
         (some #(io/resource (str full-name %))))))

(defn -compile [full-name ^CompilerConfiguration compiler-configuration]
  (let [unit (CompilationUnit. compiler-configuration)
        su   (.addSource unit (url full-name))
        cb   (reify CompilationUnit$ClassgenCallback
               (call [_ writer node]
                 (let [writer        ^ClassWriter writer
                       bytecode      (.toByteArray writer)
                       name          (.getName node)
                       ;; todo: was syncronized
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
(defn -constructor [name classname]
  (let [cname  (symbol (str "->" name))
        params (with-meta '[& args]
                 {:tag classname})]
    `(defn ~cname ~params
       (InvokerHelper/invokeConstructorOf ~classname (object-array ~'args)))))

(defn -instantiate [name classname]
  `(def ~name (InvokerHelper/invokeNoArgumentsConstructorOf ~classname)))

(defn -defclass* [name compiler-configuration]
  `(-compile ~(str name) ~compiler-configuration))

#_"
скомпилит как обычно,
хоть 2 класса, хоть скрипт



синхронизированный!!!

        synchronized Class getCompiledClass(){
                if(compiledClass == null)
//            if(RT.booleanCast(COMPILE_FILES.deref()))
//                compiledClass = RT.classForName(name);//loader.defineClass(name, bytecode);
//            else
                                {
                                loader = (DynamicClassLoader) LOADER.deref();
                                compiledClass = loader.defineClass(name, bytecode, src);
                                }
                return compiledClass;
        }

"
