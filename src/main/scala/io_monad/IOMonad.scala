package io_monad

class IOMonad[A] private(constructorCodeBlock: => A) {

  def run = constructorCodeBlock

  def flatMapOrig[B](f: A => IOMonad[B]): IOMonad[B] = IOMonad(f(run).run)

  def flatMap[B](customAlgorithm: A => IOMonad[B]): IOMonad[B] = {
    val result1: IOMonad[B] = customAlgorithm(run)
    val result2: B = result1.run
    IOMonad(result2)
  }

  def map[B](f: A => B): IOMonad[B] = flatMap(a => IOMonad(f(a)))

}

object IOMonad {
  def apply[A](a: => A): IOMonad[A] = new IOMonad(a)
}
