(ns darkleaf.clj-groovy.exceptions-test
  (:require
   [clojure.test :as t]
   [darkleaf.clj-groovy.core :as g]))

(g/defclass MyException)

(t/deftest my-exception-test
  (let [ex (try
             (throw (->MyException "foo" {:data :ok}))
             (catch MyException ex
               ex))]
    (t/is (= "foo" (ex-message ex)))
    (t/is (= {:data :ok} (ex-data ex)))))
