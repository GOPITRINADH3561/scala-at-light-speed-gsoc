package com.gopi.scala

object Functional extends App {

  // Function as a value (explicit)
  val doubler = new Function1[Int, Int] {
    def apply(x: Int): Int = x * 2
  }
  println(s"Doubled 4 = ${doubler(4)}")

  // Same thing, but shorter syntax
  val tripler: Int => Int = x => x * 3
  println(s"Tripled 4 = ${tripler(4)}")

  //  Functions with two inputs
  val greet: (String, String) => String = (name, lang) =>
    s"Hello $name! Welcome to $lang."

  println(greet("Gopi", "Scala"))

  //  Higher-order function: takes function as arg
  def applyTwice(f: Int => Int, x: Int): Int = f(f(x))

  println(applyTwice(tripler, 2)) // (2 * 3) * 3 = 18

  // map: transform elements
  val prices = List(10, 20, 30)
  val taxedPrices = prices.map(_ * 1.1)
  println(s"Taxed: $taxedPrices")

  // flatMap: expand elements
  val keywords = List("Scala", "Rocks")
  val shoutEach = keywords.flatMap(word => List(word, word.toUpperCase))
  println(shoutEach)

  //  filter: pick elements
  val nums = List(1, 2, 3, 4, 5)
  val evens = nums.filter(_ % 2 == 0)
  println(s"Evens: $evens")

  // for-comprehension: flatMap + map made readable
  val meals = List("pasta", "rice")
  val drinks = List("water", "juice")

  val menuCombos = for {
    meal <- meals
    drink <- drinks
  } yield s"$meal with $drink"

  println("Menu Combos:")
  menuCombos.foreach(println)

  // Function returning a function
  def multiplier(factor: Int): Int => Int = x => x * factor

  val timesTen = multiplier(10)
  println(timesTen(7)) // 70

  //  Function as param, return, map, and nested loops: all done 
}
