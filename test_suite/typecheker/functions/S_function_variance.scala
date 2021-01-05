class Test {

  def takesAnAnimal(a: Animal): Dog = new Dog

  def passACat(): Dog = takesAnAnimal(new Cat)
  def passADog(): Dog = takesAnAnimal(takesAnAnimal(new Animal))

  def takesAnimalFunction(f: Animal => Animal): Animal = f(new Dog)
  def takesDogFunction(f: Cat => Dog): Dog = f(new Kitten)

  def variances(d: Dog)(f: Animal => Dog): Animal = f(d)
  def variancesAgain(p: Puppy)(f2: Object => Puppy): Object = variances(p)(f2)


  def foo(): Dog = {

    takesAnimalFunction(takesAnAnimal)
    takesDogFunction(takesAnAnimal)

  }

}

class Animal
class Dog extends Animal
class Puppy extends Dog
class Cat extends Animal
class Kitten extends Cat