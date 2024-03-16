package darkleaf.clj_groovy.example.reify

@CompileStatic
class instance extends AFunction {
  static final IFn p = var('darkleaf.clj-groovy.example.reify', 'P')

  def invoke() {
    [
      a: { 42 }
    ].asType(p)
  }
}
