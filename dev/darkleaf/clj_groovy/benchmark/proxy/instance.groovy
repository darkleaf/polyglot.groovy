package darkleaf.clj_groovy.benchmark.proxy

@POJO
@CompileStatic
class instance extends AFunction {
  def invoke() {
    new AFunction() {
      def invoke() {
        42
      }
    }
  }
}
