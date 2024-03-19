package darkleaf.clj_groovy.benchmark.text_template

import groovy.text.SimpleTemplateEngine

class simple_template extends AFunction {
  static Object name = read(':darkleaf.clj-groovy.benchmark.text-template/name')

  def invoke(data) {
    def engine = new SimpleTemplateEngine()
    engine
      .createTemplate("""
        <% data.each { %>
           <%= it.with(name) %>
        <% } %>
      """)
      .make(
        data:data,
        name:name,
      )
      .toString()
  }
}
