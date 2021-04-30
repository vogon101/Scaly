class Foo {

  var _x: Int = 1
  def x: Int = {
    _x = _x + 1
    _x
  }

  def foo() : String = {

    var s = ""
    while (x < 10) {
      s = s + "!"
    }
    s

  }

}