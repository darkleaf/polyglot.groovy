package darkleaf.polyglot.groovy.benchmark.template

import groovy.xml.MarkupBuilder

// тут нужно передать как бы this, но в closure this это не сама closure
// и нужно использовать tap или аналог, он как раз захватит саму closure

@CompileDynamic
class gr_layout extends AFunction {
  def invoke(builder, inner) {
    builder.tap {
      html {
        head {
          title "test"
        }
        body {
          tap inner
        }
      }
    }
  }
}
