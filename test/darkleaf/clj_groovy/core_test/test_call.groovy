package darkleaf.clj_groovy.core_test

@CompileStatic
class test_call extends AFunction {
  static final IFn vector = var 'clojure.core', 'vector'

  def invoke() {
    // darkleaf.clj_groovy.IFnExtension
    def vector = vector // fix call operator
    [
      vector(),
      vector(1),
      vector(1, 2),
      vector(1, 2, 3),
      vector(1, 2, 3, 4),
      vector(1, 2, 3, 4, 5),
      vector(1, 2, 3, 4, 6, 7),
      vector(1, 2, 3, 4, 6, 7, 8),
      vector(1, 2, 3, 4, 6, 7, 8, 9),
      vector(1, 2, 3, 4, 6, 7, 8, 9, 10),
      vector(1, 2, 3, 4, 6, 7, 8, 9, 10, 11),
      vector(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12),
      vector(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13),
      vector(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14),
      vector(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
      vector(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16),
      vector(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17),
      vector(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18),
      vector(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19),
      vector(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
      vector(1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21),
    ]
  }
}
