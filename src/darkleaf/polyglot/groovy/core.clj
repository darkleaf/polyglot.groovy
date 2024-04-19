(ns darkleaf.polyglot.groovy.core
  (:require
    [darkleaf.polyglot.groovy.impl :as impl]))

;; deftype like
(defmacro defclass [main-class & other-classes]
  (impl/-compile (impl/-name->class-name *ns* main-class))
  `(import ~@(for [name (cons main-class other-classes)]
               (impl/-name->class-name *ns* name))))

(defmacro defobject [name]
  (let [classname (impl/-name->class-name *ns* name)]
    (impl/-compile classname)
    (impl/-instantiate name classname)))
