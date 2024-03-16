(ns darkleaf.clj-groovy.core2
  (:require
    [darkleaf.clj-groovy.impl :as impl]))

(defmacro defclass* [name]
  `(impl/-compile ~(str name)))

;; deftype like
(defmacro defclass [name]
  (let [classname (impl/-name->class-name *ns* name)]
    `(do
       (defclass* ~classname)
       (import ~classname)
       ~(impl/-constructor name classname)
       ~classname)))

(defmacro defobject [name]
  (let [classname (impl/-name->class-name *ns* name)]
    `(do
       (defclass* ~classname)
       ~(impl/-instantiate name classname)
       (var ~name))))

(comment
  (defobject foo)

  (foo)
  ,,,)
