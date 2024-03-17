package darkleaf.clj_groovy.core_test

@CompileStatic
class test_rwith extends AFunction {
  static final IFn vector = var 'clojure.core', 'vector'

  // darkleaf.clj_groovy.ObjectExtension

  // (->> "%" (vector))
  // (->> "%" (vector 1))
  // (->> "%" (vector 1 2))
  // ...

  def invoke() {
    [
      "%".rwith(vector, 1),
      "%".rwith(vector, 1, 2),
      "%".rwith(vector, 1, 2, 3),
      "%".rwith(vector, 1, 2, 3, 4),
      "%".rwith(vector, 1, 2, 3, 4, 5),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20),
      "%".rwith(vector, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21),
    ]
  }
}
