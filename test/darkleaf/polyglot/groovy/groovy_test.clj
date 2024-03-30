(ns darkleaf.polyglot.groovy.groovy-test
  (:require
   [clojure.test :as t]
   [darkleaf.polyglot.groovy.core :as g])
  (:import
   (org.codehaus.groovy.runtime InvokerHelper)))

;; может быть удалю потом
;; тут можно обкатать приколы метапрограммирования

(set! *warn-on-reflection* true)

(g/defclass ClassWithMethod)

(t/deftest ClassWithMethod-test
  (let [obj (ClassWithMethod.)]
    (t/is (= "my value" (.myMethod obj)))
    (t/is (= "my value" (InvokerHelper/invokeMethod obj "myMethod" nil)))
    ;; не понятно правильно ли так делать,
    ;; т.к. вроде дефолтная реализация в интерфейсе как раз делает что нужно,
    ;; с другой - в InvokeHelper он вызывается в catch блоке,
    ;; а с третьей - похоже на зацикливание, но его вроде бы не происходит
    ;; https://github.com/apache/groovy/blob/master/src/main/java/org/codehaus/groovy/runtime/InvokerHelper.java#L641
    ;; https://github.com/apache/groovy/blob/master/src/main/java/groovy/lang/GroovyObject.java#L39
    (t/is (= "my value" (.invokeMethod obj "myMethod" nil)))))


(g/defclass ClassWithMethodMissing)

(t/deftest ClassWithMethodMissing-test
  (let [obj (ClassWithMethodMissing.)]
    (t/is (thrown? IllegalArgumentException (.myMethod obj)))
    (t/is (= ["myMethod" []] (InvokerHelper/invokeMethod obj "myMethod" nil)))
    (t/is (= ["myMethod" [1 2 3]]
             (InvokerHelper/invokeMethod obj "myMethod" (object-array [1 2 3]))))))
