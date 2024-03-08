(ns darkleaf.clj-groovy.benchmark.collection
  (:require
   [criterium.core :as c]
   [darkleaf.clj-groovy.core :as g]))

(defn clj [data]
  (->> data
       (map inc)
       (map str)))

(g/defobject gr-1)

(g/defobject gr-2)

(g/defobject gr-3)

(comment
  (def data [1 2 3])

  (c/quick-bench (clj data))
  ;; Execution time mean : 17,571485 ns
  (c/bench (clj data))
  ;; Execution time mean : 11,834536 ns


  (c/quick-bench (gr-1 data))
  ;; Execution time mean : 46,263705 ns
  (c/bench (gr-1 data))
  ;; Execution time mean : 29,086908 ns


  (c/quick-bench (gr-2 data))
  ;; Execution time mean : 18,632078 ns
  (c/bench (gr-2 data))
  ;; Execution time mean : 12,288485 ns


  (c/quick-bench (gr-3 data))
  ;; Execution time mean : 867,550716 ns
  (c/bench (gr-3 data))
  ;; Execution time mean : 852,413420 ns

  ;; We need Kotlin!

  ,,,)
