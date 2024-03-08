configuration.recompileGroovySource = true
// configuration.minimumRecompilationInterval = 0

withConfig(configuration) {
  imports {
    normal 'clojure.lang.IFn'
    normal 'clojure.lang.AFunction'

    staticMember 'clojure.java.api.Clojure', 'var'
    staticMember 'clojure.java.api.Clojure', 'read'

    normal 'groovy.transform.CompileStatic'
  }

  // ast(groovy.transform.CompileStatic)
}

// https://docs.groovy-lang.org/latest/html/documentation/core-domain-specific-languages.html#_customizer_builder
