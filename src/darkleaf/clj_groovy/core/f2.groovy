package darkleaf.clj_groovy.core

import groovy.transform.*

import clojure.lang.*
import static clojure.java.api.Clojure.var
import static clojure.java.api.Clojure.read

@CompileStatic
class F extends AFunction {
  static IFn inc = var 'clojure.core', 'inc'
  static IFn map = var 'clojure.core', 'map'
  static IFn str = var 'clojure.core', 'str'
  static IFn foo = (IFn) read(':foo')

  def invoke(Object data) {
    def a1 = map.invoke(foo, data)
    map.invoke(inc, a1)
  }
}

new F()
