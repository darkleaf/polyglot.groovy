(ns darkleaf.clj-groovy.benchmark.reify
  (:require
   [criterium.core :as c]
   [darkleaf.clj-groovy.core :as g]))

(defprotocol P
  :extend-via-metadata true
  (a [this]))

(g/defobject instance)

;; нужно разбираться с класс-лоадерами
;; интерфейс не перезагружается, если использовать анонимный класс

(defn instance-clj []
  (reify P
    (a [_]
      42)))

(defn instance-clj2 []
  (with-meta {}
    {`a (fn [_] 42)}))

(comment
  (a (instance))
  (a (instance-clj))
  (a (instance-clj2))

  ;; reflection.Proxy :'(
  (c/quick-bench (a (instance)))
  ;; Execution time mean : 182,612822 ns

  (c/quick-bench (a (instance-clj)))
  ;; Execution time mean : 4,574165 ns

  (c/quick-bench (a (instance-clj2)))
  ;; Execution time mean : 45,350116 ns



  (let [obj (instance)]
    (c/quick-bench (a obj)))
  ;; Execution time mean : 23,560649 ns

  (let [obj (instance-clj)]
    (c/quick-bench (a obj)))
  ;; Execution time mean : 4,564991 ns

  (let [obj (instance-clj2)]
    (c/quick-bench (a obj)))
  ;; Execution time mean : 79,675511 ns
  ,,,)
