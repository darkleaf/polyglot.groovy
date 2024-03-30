package darkleaf.polyglot.groovy.benchmark.collection

@CompileDynamic
class gr_3 extends AFunction {
  def invoke(data) {
    // ++ is next()
    data*.next()*.toString()
  }
}
