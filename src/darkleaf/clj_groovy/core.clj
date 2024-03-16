(ns darkleaf.clj-groovy.core
  (:require
    [clojure.java.io :as io]
    [darkleaf.clj-groovy.impl :as impl])
  (:import
   (groovy.ui GroovyMain)
   (org.codehaus.groovy.control CompilerConfiguration)))

(defn compiler-configuration [named-resource]
  (impl/compiler-configuration named-resource))

;; deftype like
(defmacro defclass
  ([name]
   `(defclass ~name impl/default-compiler-configuration))
  ([name compiler-configuration]
   (let [classname (impl/-name->class-name *ns* name)]
     `(do
        ~(impl/-defclass* classname compiler-configuration)
        (import ~classname)
        ~(impl/-constructor name classname)
        ~classname))))

(defmacro defobject
  ([name]
   `(defobject ~name impl/default-compiler-configuration))
  ([name compiler-configuration]
   (let [classname (impl/-name->class-name *ns* name)]
     `(do
        ~(impl/-defclass* classname compiler-configuration)
        ~(impl/-instantiate name classname)
        (var ~name)))))
