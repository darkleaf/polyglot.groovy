(ns darkleaf.clj-groovy.reload
  (:require
   [clojure.java.classpath :as cp])
  (:import
   (java.io File)
   (java.nio.file Path)))

(comment
  (require '[nextjournal.beholder :as beholder])

  (def watcher
    (beholder/watch
     (fn [x]
       (def data x))
     "src"))

  (beholder/stop watcher)


  ;; наверное тут и classpath не нужен, можно просто передать списко директорий
  ;; ну и можно и classpath использоавть на стороне пользователя

  ;; find a var
  (->> (cp/classpath-directories)
       (map (fn [^File f]
              (.. f toPath toAbsolutePath)))
       (some (fn [^Path p]
               (and (.startsWith (-> data :path) p)
                    (.relativize p (-> data :path))))))



  (-> data :path)

  ,,,)
