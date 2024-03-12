(ns darkleaf.clj-groovy.benchmark.template
  (:require
   [criterium.core :as c]
   [darkleaf.clj-groovy.core :as g]
   [dev.onionpancakes.chassis.core :as ch])
  (:import
   (java.io StringWriter)
   (groovy.xml MarkupBuilder)))

(set! *warn-on-reflection* true)

(g/defobject gr-layout)

(g/defobject gr-inner)


(defn gr []
  (let [w (StringWriter.)
        b (MarkupBuilder. w)]
    (gr-layout b #'gr-inner)
    (.toString w)))

(comment
  (gr)
  (clj)

  (c/quick-bench
      (gr))
  ;; Execution time mean : 9,146391 µs

  (c/quick-bench
      (clj))
  ;; Execution time mean : 3,050910 µs
  ,,,)


(defn clj-layout [inner]
  [:html
   [:head
    [:title "test"]]
   [:body
    (inner)]])

(defn clj-inner []
  [:span {:class "inner"} "inner"])

(defn clj []
  (ch/html (clj-layout #'clj-inner)))
