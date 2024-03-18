package darkleaf.clj_groovy.groovy_test

class ClassWithMethodMissing {
  def methodMissing(String name, Object args) {
    [name, args as List]
  }
}
