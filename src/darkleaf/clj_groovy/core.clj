(ns darkleaf.clj-groovy.core
  (:require
   [criterium.core :as c]
   [clojure.java.io :as io])
  (:import
   (groovy.lang GroovyClassLoader)
   (groovy.ui GroovyMain)
   (org.codehaus.groovy.control CompilerConfiguration)
   (org.codehaus.groovy.runtime InvokerHelper)))

(set! *warn-on-reflection* true)

(def ^CompilerConfiguration compiler-configuration
  (let [cc     (CompilerConfiguration.)
        config (-> "darkleaf/clj_groovy/config.groovy" io/resource slurp)]
    (GroovyMain/processConfigScriptText config cc)
    cc))

(def ^GroovyClassLoader class-loader
  (let [cl (.. Thread currentThread getContextClassLoader)]
    (GroovyClassLoader. cl compiler-configuration)))

(defn instantiate [ns name]
  (let [full-name (munge (str ns "." name))
        klass     (.loadClass class-loader
                              full-name
                              ;; названия не говорят ничего
                              #_lookupScriptFiles true
                              ;; без false не будет перезагрузки
                              #_preferClassOverScript false
                              #_resolve true)]
    (InvokerHelper/invokeNoArgumentsConstructorOf klass)))

(defmacro defobject [klass-name]
  `(def ~klass-name (instantiate *ns* '~klass-name)))


(comment
  (defobject klass)

  (defobject use-klass)

  (use-klass))

#_
(c/quick-bench
    (example [1 2 3 4 5]))


#_
(defn example-clj [data]
  (->> data
       (map inc)
       (map str)))
#_
(c/quick-bench
    (example-clj [1 2 3 4 5]))
