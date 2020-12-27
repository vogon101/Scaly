/*
This is a member
This is another member
109
This is a member
99
 */
class Main {

  def main(): Int = {

    val f = new Foo
    print(f.member)
    print(f.otherMember)
    f.foo(99)

  }

}

class Foo {

  val member: String = "This is a member"
  var otherMember: String = "This is another member"

  def foo(n: Int): Int = {

    val x = n + 10
    print(x)
    bar(member)
    n

  }

  def bar(s: String): Unit = print(s)

}