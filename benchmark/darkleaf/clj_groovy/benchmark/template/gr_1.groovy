import groovy.xml.MarkupBuilder

new AFunction() {
  def invoke(inner) {
    def writer = new StringWriter()
    def b = new MarkupBuilder(writer)

    b.html {
      // тут нужно передать как бы this, но в closure this это не сама closure
      // и нужно использовать tap или аналог, он как раз захватит саму closure
      tap inner
    }

    writer.toString()
  }
}
