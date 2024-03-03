(ns darkleaf.clj-groovy.aot)

(gen-class
 :name darkleaf.clj_groovy.ObjectExtension
 :impl-ns darleaf.clj-groovy.aot-impl
 :prefix "obj-"
 :methods
 [^:static [with [Object, clojure.lang.IFn] Object]
  ^:static [with [Object, clojure.lang.IFn Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object Object Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  #_"больше не лезет, хоть IFn и поддерживает"
  ^:static [with [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object Object Object Object Object Object "[Ljava.lang.Object;"] Object]

  ^:static [rwith [Object, clojure.lang.IFn] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [rwith [Object, clojure.lang.IFn Object Object Object Object Object Object Object Object Object Object Object Object Object Object Object "[Ljava.lang.Object;"] Object]])

(gen-class
 :name darkleaf.clj_groovy.IFnExtension
 :impl-ns darleaf.clj-groovy.aot-impl
 :prefix "ifn-"
 :methods
 [^:static [call [clojure.lang.IFn,] Object]
  ^:static [call [clojure.lang.IFn, Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object Object Object Object Object Object Object Object Object Object Object Object] Object]
  ^:static [call [clojure.lang.IFn, Object Object Object Object Object Object Object Object Object Object Object Object Object Object Object Object "[Ljava.lang.Object;"] Object]])

(gen-class
 :name groovy.runtime.metaclass.clojure.lang.VarMetaClass
 :extends groovy.lang.DelegatingMetaClass
 :impl-ns darleaf.clj-groovy.aot-impl
 :prefix "var-meta-")
