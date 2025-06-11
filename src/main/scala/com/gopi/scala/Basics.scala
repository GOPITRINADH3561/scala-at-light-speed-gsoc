package com.gopi.scala

object Basics extends App {


  // Immutable value declaration with type
  val meaningOfLife: Int = 42 // This never changes. Like Thanos, it's inevitable.

  // Type inference in Scala
  val isScalaFun = true       // Compiler knows it's a Boolean
  val pi = 3.1415             // Compiler says: Double

  // String composition
  val name = "Gopi"
  val greeting = "Hello, " + name + "!"
  val interpolated = s"My name is $name and the meaning of life is $meaningOfLife."

  //Expressions return values
  val bonus = 2000
  val salary = 10000 + bonus  // Expression = evaluated to 12000

  val isRich = if (salary > 10000) "You're doing great!" else "Keep grinding!"

  // Code blocks return the last expression
  val introduction = {
    val job = "Data Scientist"
    val lovesScala = true
    if (lovesScala) s"$name is a $job who codes Scala"
    else s"$name prefers Python"
  }

  // Function definition
  def shout(phrase: String): String = phrase.toUpperCase + "!!!"

  // Recursive function
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else n * factorial(n - 1) // Tail recursion coming soon...

  // Unit type: like void, but actually something
  def log(msg: String): Unit = println(s"[LOG] $msg")

  // Calling our functions
  println(greeting)
  println(interpolated)
  println(isRich)
  println(introduction)
  println(shout("this is scala"))
  println(s"Factorial of 5: ${factorial(5)}")

  log("End of Basics")
}
