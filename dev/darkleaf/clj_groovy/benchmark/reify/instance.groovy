package darkleaf.clj_groovy.benchmark.reify

@CompileStatic
class instance extends AFunction {
  def invoke() {
    new P() {
      def a() {
        42
      }
    }
  }
}
