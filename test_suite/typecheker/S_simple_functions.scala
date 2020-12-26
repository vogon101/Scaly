class Test {

  def foo(n: Int): Int = n
  def bar(z: String): Int = foo(101)

  def callMe(z: Int): Int = z + 100
  def caller: String = callMe(100).toString

  def withBlock: String = {
    100
    true
    "Return value"
  }

  def +(that: Test) : Int = 100
  def op_test: Int = this + this

}