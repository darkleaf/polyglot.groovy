(ns darkleaf.polyglot.groovy.several-classes-test
  (:require
   [clojure.test :as t]
   [darkleaf.polyglot.groovy.core :as g]))

(g/defclass Foo Foo$Inner Foo$StaticInner Bar)

(t/deftest ok
  (t/is (class? Foo))
  (t/is (class? Foo$Inner))
  (t/is (class? Foo$StaticInner))
  (t/is (class? Bar)))
