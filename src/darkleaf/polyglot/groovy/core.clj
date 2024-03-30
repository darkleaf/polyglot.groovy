(ns darkleaf.polyglot.groovy.core
  (:require
    [darkleaf.polyglot.groovy.impl :as impl]))

(defn compiler-configuration [named-resource]
  (impl/compiler-configuration named-resource))

;; deftype like
(defmacro defclass [name & {:as opts}]
  (let [classname (impl/-name->class-name *ns* name)]
    `(do
       ~(impl/-defclass* classname opts)
       (import ~classname)
       ~(impl/-constructor name classname)
       ~classname)))

(defmacro defobject [name & {:as opts}]
  (let [classname (impl/-name->class-name *ns* name)]
    `(do
       ~(impl/-defclass* classname opts)
       ~(impl/-instantiate name classname)
       (var ~name))))
