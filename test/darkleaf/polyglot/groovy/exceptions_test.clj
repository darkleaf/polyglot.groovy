(ns darkleaf.polyglot.groovy.exceptions-test
  (:require
   [clojure.test :as t]
   [darkleaf.polyglot.groovy.core :as g]))

(g/defclass BaseException ConcreteException)

(t/deftest my-exception-test
  (let [ex (try
             (throw (ConcreteException. "foo" {:data :ok}))
             (catch BaseException ex
               ex))]
    (t/is (= "foo" (ex-message ex)))
    (t/is (= {:data :ok} (ex-data ex)))))
