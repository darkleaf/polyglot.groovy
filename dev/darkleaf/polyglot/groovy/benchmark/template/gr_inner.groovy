package darkleaf.polyglot.groovy.benchmark.template

@CompileDynamic
class gr_inner extends AFunction {
  def invoke(builder) {
    builder.tap {
      span class: "inner", "inner"
    }
  }
}
