package bind

case class Debuggable[A](value: A, message: String) {
  def map(f: A=> A): Debuggable[A] = {
    val newValue = f(value)
    Debuggable(newValue, message)
  }

  def flatMap(f: A => Debuggable[A]): Debuggable[A] = {
    val newValue: Debuggable[A] = f(value)
    Debuggable(newValue.value, message + "\n" + newValue.message)
  }
}

object Test extends App {

  def f(a: Int): Debuggable[Int] = {
    val result = a * 2
    val message = s"f: a ($a) * 2 = $result."
    Debuggable(result, message)
  }

  def g(a: Int): Debuggable[Int] = {
    val result = a * 3
    val message = s"g: a ($a) * 3 = $result."
    Debuggable(result, message)
  }

  def h(a: Int): Debuggable[Int] = {
    val result = a * 4
    val message = s"h: a ($a) * 4 = $result."
    Debuggable(result, message)
  }

  val finalResult = for {
    fResult <- f(100)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield hResult

  println(s"value: ${finalResult.value}\n")
  println(s"message: \n${finalResult.message}")
}