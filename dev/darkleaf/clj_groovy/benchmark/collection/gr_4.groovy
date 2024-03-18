package darkleaf.clj_groovy.benchmark.collection

class gr_4 extends AFunction {
  def invoke(data) {
    // ++ is next()
    ((List<Long>) data)*.next()*.toString()
  }
}
