configuration.parameters = true

configuration.scriptExtensions = [
  // static groovy:
  'groovy', 'gvy', 'gy',
  'sgroovy', 'sg',
  // java as static groovy
  'java',
  // dynamic groovy
  'dgroovy', 'dg'
]

withConfig(configuration) {
  imports {
    normal 'clojure.lang.IFn'
    normal 'clojure.lang.AFunction'
    normal 'clojure.lang.ExceptionInfo'

    staticMember 'clojure.java.api.Clojure', 'var'
    staticMember 'clojure.java.api.Clojure', 'read'

    normal 'groovy.transform.stc.POJO'
    normal 'groovy.transform.CompileStatic'
    normal 'groovy.transform.CompileDynamic'
  }

  source(extensions: ['groovy', 'gvy', 'gy', 'sgroovy', 'sg', 'java']) {
    ast(groovy.transform.CompileStatic)
  }
}

// https://groovy-lang.org/dsls.html#_customizer_builder
