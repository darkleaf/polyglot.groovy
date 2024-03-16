configuration.parameters = true

withConfig(configuration) {
  imports {
    normal 'clojure.lang.IFn'
    normal 'clojure.lang.AFunction'

    staticMember 'clojure.java.api.Clojure', 'var'
    staticMember 'clojure.java.api.Clojure', 'read'

    normal 'groovy.transform.stc.POJO'
    normal 'groovy.transform.CompileStatic'
    normal 'groovy.transform.CompileDynamic'
  }
}
