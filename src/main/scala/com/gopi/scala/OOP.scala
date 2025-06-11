package com.gopi.scala

// Object extends App = Scala's quick way to run main

object OOP extends App {

  // 🐾 Base class: Animal
  class Animal {
    val species = "wild"

    def eat(): Unit = println("nom nom nom...") // generic eating behavior
  }

  // 🐶 Subclass: Dog extends Animal
  class Dog(val name: String) extends Animal {
    override def eat(): Unit = println(s"$name munches on kibble 🍖")
  }

  val scooby = new Dog("Scooby")
  scooby.eat()
  println(s"Scooby is a ${scooby.species} creature")

  // 💡 Traits: Think reusable interfaces with behavior
  trait Swimmable {
    def swim(): Unit = println("Gliding through water 🏊")
  }

  trait Thinker {
    def ?!(thought: String): Unit = println(s"I wonder... $thought 🤔")
  }

  // 🐊 Multi-trait class: Crocodile philosopher swimmer
  class Crocodile(name: String)
    extends Animal with Swimmable with Thinker {

    override def eat(): Unit = println(s"$name devours prey silently 🐊")
  }

  val crocky = new Crocodile("Crocky")
  crocky.eat()
  crocky.swim()
  crocky ?! "Can we digest meaning along with meat?"

  // 🛠 Infix notation (when method has 1 param)
  crocky ?! "What is recursion but self-eating thought?"

  // 🎯 Case class: automatically generates equals, toString, apply...
  case class Programmer(name: String, language: String)

  val gopi = Programmer("Gopi", "Scala")
  val cloneGopi = Programmer("Gopi", "Scala")
  println(gopi == cloneGopi) // true, thanks to case class
  println(gopi) // Programmer(Gopi,Scala)

  // 🧙 Companion object = Singleton with static-like members
  object Programmer {
    def default(): Programmer = Programmer("Anonymous", "Scala")
  }

  val mysteryDev = Programmer.default()
  println(mysteryDev)

  // 🧪 Anonymous class
  val fish = new Animal {
    override def eat(): Unit = println("Fish goes *gulp gulp* 🐟")
  }
  fish.eat()
}
