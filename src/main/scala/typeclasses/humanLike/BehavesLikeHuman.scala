package typeclasses.humanLike

trait BehavesLikeHuman[A <: Animal] {
  def speak(a: A): Unit
  def eatHumanFood(a: A): Unit
}

object BehavesLikeHumanInstances {
  // implement an instance for a Dog
  implicit val dogBehavesLikeHuman = new BehavesLikeHuman[Dog] {
    def speak(dog: Dog): Unit = {
      println(s"I'm a Dog, my name is ${dog.name}")
    }
    def eatHumanFood(dog: Dog): Unit = {
      println(s"I ate the food you left on the table. It was good.")
    }
  }
}

object BehavesLikeHumanSyntax {
  implicit class BehavesLikeHumanOps[A <: Animal](value: A) {
    def speak(implicit behavesLikeHumanInstance: BehavesLikeHuman[A]): Unit = {
      behavesLikeHumanInstance.speak(value)
    }
    def eatHumanFood(implicit behavesLikeHumanInstance: BehavesLikeHuman[A]): Unit = {
      behavesLikeHumanInstance.eatHumanFood(value)
    }
  }


}
