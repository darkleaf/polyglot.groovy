package darkleaf.clj_groovy.core_test

@POJO
@CompileStatic
class test_fn extends AFunction {
  def invoke() {
    []
  }

  def invoke(x) {
    [x]
  }
}
