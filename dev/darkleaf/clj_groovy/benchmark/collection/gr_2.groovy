package darkleaf.clj_groovy.benchmark.collection

IFn deref = var 'clojure.core', 'deref'

// эти Var не будут меняться, и можем сразу их задерефить
// но тут внурти используется groovy.lang.Reference
IFn mapv = (IFn) var('clojure.core', 'mapv').with(deref)
IFn inc  = (IFn) var('clojure.core', 'inc' ).with(deref)
IFn str  = (IFn) var('clojure.core', 'str' ).with(deref)

new AFunction() {
  @CompileStatic
  def invoke(data) {
    data
      .rwith(mapv, inc)
      .rwith(mapv, str)
  }
}
