package com.gopi.scala

object PatternMatching extends App {

  // Basic integer match
  val dayCode = 3
  val day = dayCode match {
    case 1 => "Monday"
    case 2 => "Tuesday"
    case 3 => "Wednesday"
    case 4 => "Thursday"
    case 5 => "Friday"
    case _ => "Weekend or Invalid Day"
  }
  println(s"Today is: $day")

  // 👤 Matching with case classes
  case class Developer(name: String, knowsScala: Boolean)

  val dev = Developer("Gopi", knowsScala = true)
  val intro = dev match {
    case Developer(name, true) => s"$name codes in Scala"
    case Developer(name, false) => s"$name prefers another path"
  }
  println(intro)

  // Matching tuples
  val rgb = (255, 255, 0)
  val colorType = rgb match {
    case (255, 0, 0) => "Red"
    case (0, 255, 0) => "Green"
    case (0, 0, 255) => "Blue"
    case (r, g, b) if r == g && b == 0 => "Yellow"
    case _ => "Custom RGB Color"
  }
  println(s"Color type: $colorType")

  // Matching lists
  val shoppingList = List("milk", "eggs", "bread")
  val listMessage = shoppingList match {
    case List("milk", _, _) => "You're starting strong with milk"
    case List(_, "eggs", _) => "Eggs are in the middle"
    case _ => "Interesting grocery combo"
  }
  println(listMessage)

  // Pattern guards
  val age = 20
  val ageStatus = age match {
    case x if x < 13 => "Child"
    case x if x < 20 => "Teen"
    case x if x < 60 => "Adult"
    case _ => "Senior"
  }
  println(s"You are classified as: $ageStatus")

  //  Default or wildcard case
  def animalSound(animal: String): String = animal match {
    case "dog" => "woof!"
    case "cat" => "meow!"
    case "cow" => "moo!"
    case _ => "Unknown creature"
  }

  println(animalSound("dog"))
  println(animalSound("dragon"))

  // Matching with Option
  val maybeFavorite: Option[String] = Some("Scala")
  val favoriteLang = maybeFavorite match {
    case Some("Scala") => "Yes, you’re enlightened"
    case Some(lang) => s"You like $lang — interesting!"
    case None => "Pick a favorite language!"
  }
  println(favoriteLang)
}
