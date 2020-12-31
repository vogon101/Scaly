class Thing
class Duck extends Thing

class Test {

  val puppy: Puppy = new Puppy
  puppy.woof()

  def f(x: Thing): Unit = {
    print(x)
  }

  f(puppy.toy)
  f((new Dog).toy)

}

class Dog {

  def woof(): String = "Woof"

  val toy: Thing = new Thing

}

class Puppy extends Dog {

  val toy: Duck = new Duck

}

