package darkleaf.clj_groovy.benchmark.collection

IFn map = var 'clojure.core', 'map'

IFn inc = var 'clojure.core', 'inc'
IFn str = var 'clojure.core', 'str'

new AFunction() {
  def invoke(data) {
    data
      .rwith(map, inc)
      .rwith(map, str)
  }
}
