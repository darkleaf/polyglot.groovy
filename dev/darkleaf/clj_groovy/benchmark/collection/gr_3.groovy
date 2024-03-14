package darkleaf.clj_groovy.benchmark.collection

class gr_3 extends AFunction {
  def invoke(data) {
    // ++ is next()
    data*.next()*.toString()
  }
}
