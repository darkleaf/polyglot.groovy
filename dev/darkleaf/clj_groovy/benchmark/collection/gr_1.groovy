package darkleaf.clj_groovy.benchmark.collection

IFn mapv = var 'clojure.core', 'mapv'

IFn inc = var 'clojure.core', 'inc'
IFn str = var 'clojure.core', 'str'

new AFunction() {
  def invoke(data) {
    data
      .rwith(mapv, inc)
      .rwith(mapv, str)
  }
}
