package darkleaf.clj_groovy.core

import clojure.lang.*
import static clojure.java.api.Clojure.var
import static clojure.java.api.Clojure.read

IFn deref = var 'clojure.core', 'deref'

IFn klass = var 'darkleaf.clj-groovy.core', 'klass'

new AFunction() {
  def invoke() {
    Class X = klass.with(deref)

    [
      X.bar(),
      X.newInstance().xyz(),
    ]
  }
}
