(ns darkleaf.clj-groovy.benchmark.template
  (:require
   [criterium.core :as c]
   [darkleaf.clj-groovy.core :as g])
  #_(:import
     (groovy.xml MarkupBuilder)))

(g/defobject gr-inner)

(g/defobject gr-1)

(comment
  (gr-1 gr-inner)
  ,,,)


(c/quick-bench
    (gr-1))
