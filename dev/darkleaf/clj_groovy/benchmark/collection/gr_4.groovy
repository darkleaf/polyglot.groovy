package darkleaf.clj_groovy.benchmark.collection

new AFunction() {
  @CompileStatic
  def invoke(data) {
    // ++ is next()
    ((List<Long>) data)*.next()*.toString()
  }
}
