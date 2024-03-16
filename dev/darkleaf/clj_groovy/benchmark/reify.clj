(ns darkleaf.clj-groovy.benchmark.reify
  (:require
   [criterium.core :as c]
   [darkleaf.clj-groovy.core :as g]))

(defprotocol P
  (a [this]))

(g/defobject instance)

;; нужно разбираться с класс-лоадерами
;; интерфейс не перезагружается, если использовать анонимный класс

(defn instance-clj []
  (reify P
    (a [_]
      42)))

(comment
  (a (instance))
  (a (instance-clj))

  ;; reflection.Proxy :'(
  (c/quick-bench (a (instance)))
  ;; Execution time mean : 215,461238 ns

  (c/quick-bench (a (instance-clj)))
  ;; Execution time mean : 5,336916 ns

  (let [obj (instance)]
    (c/quick-bench (a obj)))
  ;; Execution time mean : 26,407025 ns

  (let [obj (instance-clj)]
    (c/quick-bench (a obj)))
  ;; Execution time mean : 5,073003 ns
  ,,,)
