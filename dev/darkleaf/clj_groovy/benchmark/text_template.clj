(ns darkleaf.clj-groovy.benchmark.text-template
  (:require
   [darkleaf.clj-groovy.core :as g]))

(do
  (g/defobject simple-template)
  (simple-template [{::name "A"}
                    {::name "B"}]))
