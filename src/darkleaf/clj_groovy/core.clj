(ns darkleaf.clj-groovy.core
  (:require
   [criterium.core :as c]
   [clojure.java.io :as io]
   [clojure.java.classpath :as cp])
  (:import
   (java.io File)
   (java.nio.file Path)
   (groovy.lang GroovyClassLoader)
   (groovy.ui GroovyMain)
   (org.codehaus.groovy.control CompilerConfiguration)
   (org.codehaus.groovy.control.customizers CompilationCustomizer
                                            ImportCustomizer)
   (org.codehaus.groovy.runtime InvokerHelper)))

(set! *warn-on-reflection* true)

(def ^GroovyClassLoader class-loader
  (let [cc     (CompilerConfiguration.)
        config (-> "darkleaf/clj_groovy/config.groovy" io/resource slurp)
        _      (GroovyMain/processConfigScriptText config cc)
        cl     (.. Thread currentThread getContextClassLoader)]
    (GroovyClassLoader. cl cc)))


(defn run-script [ns name]
  (let [full-name    (munge (str ns "." name))
        ;; без второго false не будет перезагрузки
        script-class (.loadClass class-loader full-name true false true)]
    (InvokerHelper/runScript script-class nil)))

(defmacro defobject [script-name]
  `(def ~script-name (run-script *ns* '~script-name)))


(comment
  (require '[nextjournal.beholder :as beholder])

  (def watcher
    (beholder/watch
     (fn [x]
       (def data x))
     "src"))

  (beholder/stop watcher)


  ;; find a var
  (->> (cp/classpath-directories)
       (map (fn [^File f]
              (.. f toPath toAbsolutePath)))
       (some (fn [^Path p]
               (and (.startsWith (-> data :path) p)
                    (.relativize p (-> data :path))))))



  ,,,)

(-> data :path)


(defobject f1)

(comment
  (f1 [{::foo 2}])


  (do
    (defobject f2)
    (f2 [{:foo 2}]))

  ,,,)

;; Execution time mean : 48,473920 ns

(comment
  (c/quick-bench
      (f2 [{:foo 1}]))
  ,,,)


(defn f1-clj [data]
  (->> data
       (map :foo)
       (map inc)))

(comment
  (c/quick-bench
      (f1-clj [{:foo 2}]))
  ,,,)

;;              Execution time mean : 18,969550 ns


(comment
  (defobject klass)

  (defobject use-klass)

  (use-klass))

#_
(c/quick-bench
    (example [1 2 3 4 5]))


#_
(defn example-clj [data]
  (->> data
       (map inc)
       (map str)))
#_
(c/quick-bench
    (example-clj [1 2 3 4 5]))


(defn- path->var [])
