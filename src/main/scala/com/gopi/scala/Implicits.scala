package com.gopi.scala

object Implicits extends App {

  // #1 IMPLICIT ARGUMENTS — pass without actually passing
  def boostScore(base: Int)(implicit multiplier: Int): Int = base * multiplier

  implicit val defaultMultiplier: Int = 3

  val baseScore = 10
  val finalScore = boostScore(baseScore) // Scala auto-fills the multiplier
  println(s"Boosted score (10 x 3): $finalScore")

  //#2 TYPE ENRICHMENT — add methods to existing types
  implicit class RichInt(val x: Int) {
    def isEven: Boolean = x % 2 == 0

    def square: Int = x * x

    def emojiTimes(emoji: String): String = emoji * x
  }

  println(42.isEven) // true
  println(7.square) // 49
  println(3.emojiTimes("🚀")) // 🚀🚀🚀

  //Even works with val reuse
  val number = 5
  if (number.isEven) println("Even stevens!")
  else println("Odd one out!")

  // Implicits can be tricky — avoid magic
  def greet(name: String)(implicit greeting: String): String =
    s"$greeting, $name!"

  implicit val defaultGreeting: String = "Namaste"
  println(greet("Gopi")) // "Namaste, Gopi!"

  // Implicit conversions with context
  case class User(name: String)

  implicit def stringToUser(name: String): User = User(name)

  def welcomeUser(user: User): String = s"Welcome, ${user.name}!"

  println(welcomeUser("Trinadh")) // auto-converts String → User

  //Best practice: use implicit classes and vals, avoid defs unless needed.
}
