package darkleaf.clj_groovy.core_test

@POJO
@CompileStatic
class test_read extends AFunction {
  def invoke() {
    read ':x'
  }
}
