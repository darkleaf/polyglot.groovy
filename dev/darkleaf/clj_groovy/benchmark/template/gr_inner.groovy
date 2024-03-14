package darkleaf.clj_groovy.benchmark.template

class gr_inner extends AFunction {
  def invoke(builder) {
    builder.tap {
      span class: "inner", "inner"
    }
  }
}
