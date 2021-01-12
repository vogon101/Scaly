class Test {

  def foo(n: Int): Int = n
  def bar(z: String): Int = foo(101)

  def callMe(z: Int): Int = z + 100
  //TODO: Autoboxing (or equiv) to allow value types to have .toString etc
  def caller: String = str(callMe(100))

  def withBlock: String = {
    100
    true
    "Return value"
  }

  def +(that: Test) : Int = 100
  def op_test: Int = this + this

}