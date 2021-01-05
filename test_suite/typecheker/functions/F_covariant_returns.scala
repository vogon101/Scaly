class Test {

  def foo(f: Dog => Dog): Puppy = f(new Dog)

}

class Animal
class Dog extends Animal
class Puppy extends Dog