package darkleaf.polyglot.groovy.groovy_test

class ClassWithMethodMissing {
  def methodMissing(String name, Object args) {
    [name, args as List]
  }
}
