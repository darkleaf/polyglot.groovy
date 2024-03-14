(ns darkleaf.clj-groovy.benchmark.collection
  (:require
   [criterium.core :as c]
   [darkleaf.clj-groovy.core :as g]))

;; mapv намеренно используется, чтобы не было ленивости
(defn clj [data]
  (->> data
       (mapv inc)
       (mapv str)))

(defn clj-2 [data]
  (into []
        (comp (map inc)
              (map str))
        data))


(g/defobject gr-1)

(g/defobject gr-2)

(g/defobject gr-3)

(g/defobject gr-4)

(comment
  (def data [1 2 3])

  (c/quick-bench (clj data))
  ;; Execution time mean : 515,502287 ns

  (c/quick-bench (clj-2 data))
  ;; Execution time mean : 489,407614 ns

  (c/quick-bench (gr-1 data))
  ;; Execution time mean : 676,218216 ns

  ;; CompileStatic + var deref
  (c/quick-bench (gr-2 data))
  ;; Execution time mean : 534,566292 ns

  ;; dynamic groovy and j.u.ArrayList
  (c/quick-bench (gr-3 data))
  (class (gr-3 data))
  ;; Execution time mean : 642,891434 ns

  ;; type hint, CompileStatic, and j.u.ArrayList
  (c/quick-bench (gr-4 data))
  ;; Execution time mean : 123,405755 ns

  ,,,)
