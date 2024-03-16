(ns darkleaf.clj-groovy.example.reify
  (:require
   [darkleaf.clj-groovy.core :as g]))

(defprotocol P
  (a [this]))

(g/defobject instance)

(comment
  (a (instance))

  (-> (instance)
      class)
  ,,,)
