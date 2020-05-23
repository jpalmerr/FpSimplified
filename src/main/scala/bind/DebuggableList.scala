package bind

case class DebuggableList[A](value: A, log: List[String]) {

  def map[B](f: A => B): DebuggableList[B] = {
    val nextValue = f(value)
    DebuggableList(nextValue, this.log)
  }

  def flatMap[B](f: A => DebuggableList[B]): DebuggableList[B] = {
    val nextValue: DebuggableList[B] = f(value)
    DebuggableList(nextValue.value, this.log ::: nextValue.log)
  }
}

object DebuggableListTest extends App {

  def f(a: Int): DebuggableList[Int] = {
    val result = a * 2
    DebuggableList(result, List(s"f: multiply $a * 2 = $result"))
  }

  def g(a: Int): DebuggableList[Int] = {
    val result = a * 3
    DebuggableList(result, List(s"g: multiply $a * 3 = $result"))
  }

  def h(a: Int): DebuggableList[Int] = {
    val result = a * 4
    DebuggableList(result, List(s"h: multiply $a * 4 = $result"))
  }

  val finalResult = for {
    fRes <- f(100)
    gRes <- g(fRes)
    hRes <- h(gRes)
  } yield s"result: $hRes"

  finalResult.log.foreach(l => println(s"LOG: $l"))
  println(s"Output is ${finalResult.value}")

}
