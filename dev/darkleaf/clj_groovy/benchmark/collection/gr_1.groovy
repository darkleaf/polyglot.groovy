package darkleaf.clj_groovy.benchmark.collection

class gr_1 extends AFunction {
  static final IFn mapv = var 'clojure.core', 'mapv'
  static final IFn inc  = var 'clojure.core', 'inc'
  static final IFn str  = var 'clojure.core', 'str'

  def invoke(data) {
    data
      .rwith(mapv, inc)
      .rwith(mapv, str)
  }
}
