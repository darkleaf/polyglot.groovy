package darkleaf.clj_groovy.benchmark.reify

class instance extends AFunction {
  def invoke() {
    new P() {
      def a() {
        42
      }
    }
  }
}
