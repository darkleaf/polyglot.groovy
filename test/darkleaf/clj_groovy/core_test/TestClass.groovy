package darkleaf.clj_groovy.core_test

@POJO
@CompileStatic
class TestClass {
  List args

  TestClass() {
    this.args = []
  }

  TestClass(a, b, c) {
    this.args = [a, b, c]
  }
}
