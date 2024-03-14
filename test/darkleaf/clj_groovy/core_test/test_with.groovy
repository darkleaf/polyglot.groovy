package darkleaf.clj_groovy.core_test

class test_with extends AFunction {
  static final IFn vector = var 'clojure.core', 'vector'

  // darkleaf.clj_groovy.ObjectExtension

  // (-> "%" (vector))
  // (-> "%" (vector 1))
  // (-> "%" (vector 1 2))
  // ...

  def invoke() {
    [
      "%".with(vector),
      "%".with(vector, 1),
      "%".with(vector, 1, 2),
      "%".with(vector, 1, 2, 3),
      "%".with(vector, 1, 2, 3, 4),
      "%".with(vector, 1, 2, 3, 4, 5),
      "%".with(vector, 1, 2, 3, 4, 6, 7),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
      "%".with(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21),
    ]
  }
}
