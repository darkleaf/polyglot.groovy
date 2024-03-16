(ns darkleaf.clj-groovy.core-test
  (:require
   [darkleaf.clj-groovy.core :as g]
   [clojure.test :as t]))

(set! *warn-on-reflection* true)

(g/defclass TestClass)

(t/deftest class-test
  (t/is (= [] (.getArgs (->TestClass))))
  (t/is (= [] (.getArgs (TestClass.))))
  (t/is (= [1 2 3] (.getArgs (->TestClass 1 2 3))))
  (t/is (= [1 2 3] (.getArgs (TestClass. 1 2 3)))))

(g/defobject test-object)

(t/deftest object-test
  (t/is (= "test object" (str test-object))))


(g/defobject test-fn)

(t/deftest fn-test
  (t/is (= [] (test-fn)))
  (t/is (= [] (apply test-fn [])))

  (t/is (= [::x] (test-fn ::x)))
  (t/is (= [::x] (apply test-fn [::x]))))


(g/defobject test-read)

(t/deftest read-test
  (t/is (= :x (test-read))))


(g/defobject test-var)

(t/deftest var-test
  (t/is (= #'inc (test-var))))


(g/defobject test-call)

(t/deftest call-test
  (t/is (= [[]
            [1]
            [1 2]
            [1 2 3]
            [1 2 3 4]
            [1 2 3 4 5]
            [1 2 3 4 6 7]
            [1 2 3 4 6 7 8]
            [1 2 3 4 6 7 8 9]
            [1 2 3 4 6 7 8 9 10]
            [1 2 3 4 6 7 8 9 10 11]
            [1 2 3 4 6 7 8 9 10 11 12]
            [1 2 3 4 6 7 8 9 10 11 12 13]
            [1 2 3 4 6 7 8 9 10 11 12 13 14]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 16]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 18]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 18 19]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21]]
           (test-call))))


;; todo: test-tap

#_#_
(g/defobject test-tap)
(t/deftest tap-test)


(g/defobject test-with)

(t/deftest with-test
  (t/is (= [["%"]
            ["%" 1]
            ["%" 1 2]
            ["%" 1 2 3]
            ["%" 1 2 3 4]
            ["%" 1 2 3 4 5]
            ["%" 1 2 3 4 6 7]
            ["%" 1 2 3 4 6 7 8]
            ["%" 1 2 3 4 6 7 8 9]
            ["%" 1 2 3 4 6 7 8 9 10]
            ["%" 1 2 3 4 6 7 8 9 10 11]
            ["%" 1 2 3 4 6 7 8 9 10 11 12]
            ["%" 1 2 3 4 6 7 8 9 10 11 12 13]
            ["%" 1 2 3 4 6 7 8 9 10 11 12 13 14]
            ["%" 1 2 3 4 6 7 8 9 10 11 12 13 14 15]
            ["%" 1 2 3 4 6 7 8 9 10 11 12 13 14 15 16]
            ["%" 1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17]
            ["%" 1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 18]
            ["%" 1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 18 19]
            ["%" 1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20]
            ["%" 1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21]]
           (test-with))))


(g/defobject test-rwith)

(t/deftest rwith-test
  (t/is (= [[1 "%"]
            [1 2 "%"]
            [1 2 3 "%"]
            [1 2 3 4 "%"]
            [1 2 3 4 5 "%"]
            [1 2 3 4 6 7 "%"]
            [1 2 3 4 6 7 8 "%"]
            [1 2 3 4 6 7 8 9 "%"]
            [1 2 3 4 6 7 8 9 10 "%"]
            [1 2 3 4 6 7 8 9 10 11 "%"]
            [1 2 3 4 6 7 8 9 10 11 12 "%"]
            [1 2 3 4 6 7 8 9 10 11 12 13 "%"]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 "%"]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 "%"]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 "%"]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 "%"]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 18 "%"]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 18 19 "%"]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 "%"]
            [1 2 3 4 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 "%"]]
           (test-rwith))))
