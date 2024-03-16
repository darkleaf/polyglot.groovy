(ns darkleaf.clj-groovy.core
  (:require
    [darkleaf.clj-groovy.impl :as impl]))

;; deftype like
(defmacro defclass [name]
  (let [classname (impl/-name->class-name *ns* name)]
    `(do
       ~(impl/-defclass* classname)
       (import ~classname)
       ~(impl/-constructor name classname)
       ~classname)))

(defmacro defobject [name]
  (let [classname (impl/-name->class-name *ns* name)]
    `(do
       ~(impl/-defclass* classname)
       ~(impl/-instantiate name classname)
       (var ~name))))
