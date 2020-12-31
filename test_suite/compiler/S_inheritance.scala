/*
Constructor of Dog
Woof
Quack
Constructor of Dog
This is a thing
This is a thing
I am puppy
None
 */

class Main {

  def main(): Unit = {

    val test = new Test
    test.foo()
    test.f(new Thing)
    print(test.puppy.toString())

  }

}

class Thing {

  override def toString: String = "This is a thing"

}

class Duck extends Thing {

  override def toString: String = "Quack"

}

class Test {

  val puppy: Puppy = new Puppy

  def foo(): Unit = {
    print(puppy.woof())
    f(puppy.toy)
    f((new Dog).toy)
  }

  def f(x: Thing): Unit = {
    print(x)
  }



}

class Dog {

  print("Constructor of Dog")

  def woof(): String = "Woof"

  val toy: Thing = new Thing

  override def toString: String = "I am Dog"

}

class Puppy extends Dog {

  val toy: Duck = new Duck

  override def toString: String = "I am puppy"

}

