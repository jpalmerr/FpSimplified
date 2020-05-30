package typeclasses.humanLike

object HumanLikeDriver extends App {

  import BehavesLikeHumanInstances.dogBehavesLikeHuman
  import BehavesLikeHumanSyntax.BehavesLikeHumanOps

  val rover = Dog("Rover")
  rover.speak

}
