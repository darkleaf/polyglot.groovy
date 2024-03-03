package example

import groovy.transform.CompileStatic

import clojure.lang.AFn
import clojure.lang.IFn
import static clojure.java.api.Clojure.var

class Example extends AFn {
  IFn map = var 'clojure.core', 'map'
  IFn inc = var 'clojure.core', 'inc'
  IFn str = var 'clojure.core', 'str'

  Object invoke() {
    209
  }


  // 64,784870 µs
  // 174,774615 ns CompileStatic
  // @CompileStatic
  Object invoke(data) {
    data
      .with{ map.invoke inc, it }
      .with{ map.invoke inc, it }
      .with{ map.invoke inc, it }
      .with{ map.invoke str, it }
  }

  /*
  // groovy 44,941972 ns
  // clj    20,875858 ns
  Object invoke(data) {
    data = map.invoke inc, data
    data = map.invoke str, data
    data
  }
   */

}
