package darkleaf.clj_groovy.core

def cc = ns 'clojure.core'

def inc = cc.var 'inc'
def map = cc.var 'map'
def str = cc.var 'str'

def foo = ns 'darkleaf.clj-groovy.core' key 'foo'

new AFunction() {
  def invoke(data) {
    data
      .rwith(map, foo)
      .rwith(map, inc)
      .rwith(map, str)
  }
}
