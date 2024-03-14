new AFunction() {
  def invoke(builder) {
    builder.tap {
      span class: "inner", "inner"
    }
  }
}
