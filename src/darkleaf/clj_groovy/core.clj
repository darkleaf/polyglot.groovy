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

(defn run-script [ns name]
  (let [full-name    (munge (str ns "." name))
        ;; без второго false не будет перезагрузки
        script-class (.loadClass class-loader full-name true false true)]
    (InvokerHelper/runScript script-class nil)))

(defmacro defobject [script-name]
  `(def ~script-name (run-script *ns* '~script-name)))


(comment
  (defobject f1)

  (f1 [{::foo 2}])


  (do
    (defobject f2)
    (f2 [{:foo 2}]))

  ,,,)

;; Execution time mean : 48,473920 ns

(comment
  (c/quick-bench
      (f2 [{:foo 1}]))
  ,,,)


(defn f1-clj [data]
  (->> data
       (map :foo)
       (map inc)))

(comment
  (c/quick-bench
      (f1-clj [{:foo 2}]))
  ,,,)

;;              Execution time mean : 18,969550 ns


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
