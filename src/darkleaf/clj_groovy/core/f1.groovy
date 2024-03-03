package darkleaf.clj_groovy.core

import clojure.lang.AFunction
import clojure.lang.IFn
import static clojure.java.api.Clojure.var
import static clojure.java.api.Clojure.read

IFn inc = var 'clojure.core', 'inc'
IFn map = var 'clojure.core', 'map'
IFn str = var 'clojure.core', 'str'

IFn foo = (IFn) read(':foo')


new AFunction() {
  def invoke(Object data) {
    data
      .rwith(map, foo)
      .rwith(map, inc)
  }
}
