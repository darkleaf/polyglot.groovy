(ns darkleaf.clj-groovy.benchmark.proxy
  (:require
   [criterium.core :as c]
   [darkleaf.clj-groovy.core :as g])
  (:import
   [clojure.lang AFunction]))

(g/defobject instance)

(defn instance-clj []
  (proxy [AFunction] []
    (invoke []
      42)))

(comment
  ((instance))
  ((instance-clj))

  (let [f (instance)]
    (c/quick-bench (f)))
  ;; Execution time mean : 1,885277 ns

  (let [f (instance-clj)]
    (c/quick-bench (f)))
  ;; Execution time mean : 14,896429 ns
  ,,,)
