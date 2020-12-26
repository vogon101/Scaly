class Test {

  def foo(f: Dog => Puppy): Puppy = f(new Animal)

}

class Animal
class Dog extends Animal
class Puppy extends Dog
class Cat extends Animal
class Kitten extends Cat