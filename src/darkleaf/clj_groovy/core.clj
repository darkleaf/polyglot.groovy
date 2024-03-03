(ns darkleaf.clj-groovy.core
  (:require
   [criterium.core :as c])
  (:import
   (groovy.lang GroovyClassLoader)
   (org.codehaus.groovy.control CompilerConfiguration)
   (org.codehaus.groovy.runtime InvokerHelper)))

(set! *warn-on-reflection* true)


(defonce ^GroovyClassLoader class-loader
  (doto (GroovyClassLoader.
         (.. Thread currentThread getContextClassLoader)
         (doto (CompilerConfiguration.)
           (.setRecompileGroovySource true)
           #_(.setMinimumRecompilationInterval 0)))))


(defn run-script [ns name]
  (let [full-name    (munge (str ns "." name))
        ;; без второго false не будет перезагрузки
        script-class (.loadClass class-loader full-name true false true)]
    (InvokerHelper/runScript script-class nil)))

(defmacro defobject [script-name]
  `(def ~script-name (run-script *ns* '~script-name)))


(defobject f1)

(comment
  (f1 [{:foo 2}])
  ,,,)

;; Execution time mean : 48,473920 ns

(comment
  (c/quick-bench
      (f1 [{:foo 1}])))


(defn f1-clj [data]
  (->> data
       (map :foo)
       (map inc)))

#_
(c/quick-bench
    (f1-clj [{:foo 1}]))

;;              Execution time mean : 18,969550 ns




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
