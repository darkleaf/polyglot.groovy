package darkleaf.clj_groovy.benchmark.collection

new AFunction() {
  def invoke(data) {
    // ++ is next()
    data*.next()*.toString()
  }
}
