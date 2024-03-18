package darkleaf.clj_groovy.benchmark.collection

class gr_2 extends AFunction {
  static final IFn deref = var 'clojure.core', 'deref'

  // эти Var не будут меняться, и можем сразу их задерефить
  static final IFn mapv = (IFn) (var 'clojure.core', 'mapv' with deref)
  static final IFn inc  = (IFn) (var 'clojure.core', 'inc'  with deref)
  static final IFn str  = (IFn) (var 'clojure.core', 'str'  with deref)

  def invoke(data) {
    data
      .rwith(mapv, inc)
      .rwith(mapv, str)
  }
}
