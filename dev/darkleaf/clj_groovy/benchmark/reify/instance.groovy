package darkleaf.clj_groovy.benchmark.reify

@CompileStatic
class instance extends AFunction {
  static final IFn P = var('darkleaf.clj-groovy.benchmark.reify', 'P')
  static final Object onInterface = read(":on-interface")

  def invoke() {
    reify P, [
      a: { 42 }
    ]
  }

  // reflection.Proxy
  def reify(IFn protocol, Map spec) {
    Class klass = protocol(onInterface)
    spec.asType klass
  }
}
