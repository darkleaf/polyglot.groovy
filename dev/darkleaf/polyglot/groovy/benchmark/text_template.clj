(ns darkleaf.polyglot.groovy.benchmark.text-template
  (:require
   [darkleaf.polyglot.groovy.core :as g]))

(do
  (g/defobject simple-template)
  (simple-template [{::name "A"}
                    {::name "B"}]))
