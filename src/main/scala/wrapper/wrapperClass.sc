case class Wrapper[Int](value: Int) {
  def map(f: Int => Int): Wrapper[Int] = {
    val newInt = f(value)
    Wrapper(newInt)
  }
  def flatMap(f: Int => Wrapper[Int]): Wrapper[Int] = f(value)

  override def toString = value.toString
}

val result: Wrapper[Int] = for {
  a <- Wrapper(1)
  b <- Wrapper(2)
  c <- Wrapper(3)
} yield a + b + c

case class genericWrapper[A](value: A) {
  def map(f: A => A): genericWrapper[A] = {
    val newInt = f(value)
    new genericWrapper(newInt)
  }
  def flatMap(f: A => genericWrapper[A]): genericWrapper[A] = f(value)

  override def toString = value.toString
}

val intResult: genericWrapper[Int] = for {
  x <- genericWrapper(1)
  y <- genericWrapper(2)
  z <- genericWrapper(3)
} yield x + y + z


val stringResult: genericWrapper[String] = for {
  a <- genericWrapper("a")
  b <- genericWrapper("b")
  c <- genericWrapper("c")
} yield a + b + c