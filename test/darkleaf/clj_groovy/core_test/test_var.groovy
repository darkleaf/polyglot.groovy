package darkleaf.clj_groovy.core_test

@POJO
@CompileStatic
class test_var extends AFunction {
  def invoke() {
    var 'clojure.core', 'inc'
  }
}
