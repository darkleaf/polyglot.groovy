package darkleaf.clj_groovy.core_test

@CompileStatic
class test_var extends AFunction {
  def invoke() {
    var 'clojure.core', 'inc'
  }
}
