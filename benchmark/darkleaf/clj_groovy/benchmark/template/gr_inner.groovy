new AFunction() {
  def invoke(ctx) {
    ctx.tap {
      span "inner"
    }
  }
}
