configuration.recompileGroovySource = true
// configuration.minimumRecompilationInterval = 0

withConfig(configuration) {
  imports {
    star 'clojure.lang'
    staticMember 'darkleaf.clj_groovy.ClojureDSL', 'ns'
    staticMember 'darkleaf.clj_groovy.ClojureDSL', 'read'
  }

  // ast(groovy.transform.CompileStatic)
}

// https://docs.groovy-lang.org/latest/html/documentation/core-domain-specific-languages.html#_customizer_builder
