package com.gopi.blog

object ContextualAbstractions:

  //  Contextual parameters with `using` and `given`
  given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _)

  val numbers = List(5, 1, 3, 2, 4)
  val sortedDesc = numbers.sorted // uses the given Ordering
  println(s"Sorted descending: $sortedDesc")

  // Type class example: a Combinator for custom behavior
  trait Combinator[A]:
    def combine(x: A, y: A): A

  given intCombinator: Combinator[Int] with
    def combine(x: Int, y: Int): Int = x + y

  def combineAll[A](list: List[A])(using combinator: Combinator[A]): A =
    list.reduce(combinator.combine)

  val total = combineAll(numbers)
  println(s"Combined total: $total")

  // 🍭 Context bounds version (shorter syntax)
  def combineAll_v2[A: Combinator](list: List[A]): A =
    combineAll(list)

  println(s"Combined using v2: ${combineAll_v2(numbers)}")

  // Extension Methods – add methods to existing types
  case class Person(name: String)

  extension (p: Person)
    def greet: String = s"Hi, I’m ${p.name}, and I love Scala 3!"

  val gopi = Person("Gopi")
  println(gopi.greet)

  // 🛠 Extension for List[A] to reuse combinator
  extension [A](list: List[A])
    def combineAllValues(using comb: Combinator[A]): A =
      list.reduce(comb.combine)

  val autoTotal = numbers.combineAllValues
  println(s"Auto-combined with extension: $autoTotal")

  @main def run(): Unit =
    println("Scala 3 Contextual Magic Demo")
