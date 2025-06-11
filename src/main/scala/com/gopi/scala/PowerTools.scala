package com.gopi.scala

import scala.util.{Try, Success, Failure}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.Await

object PowerTools extends App {

  // ⚡ LAZY Evaluation — runs only when accessed
  lazy val lazyComputation = {
    println("Lazy value is now being evaluated...")
    99 + 1
  }

  println("Nothing has happened yet...")
  println(s"Lazy value: $lazyComputation") // now it triggers

  // OPTION — Wrapping the dangerous world of null
  def getUsernameFromDB(id: Int): Option[String] =
    if (id == 1) Some("GopiTrinadh") else None

  val user1 = getUsernameFromDB(1)
  val user2 = getUsernameFromDB(999)

  def greetUser(optUser: Option[String]): String = optUser match {
    case Some(name) => s"Hello, $name!"
    case None => "No user found."
  }

  println(greetUser(user1))
  println(greetUser(user2))

  // TRY — Handling failures like a grown-up
  def riskyMath(dividend: Int, divisor: Int): Int = dividend / divisor

  val safeDivision = Try(riskyMath(10, 2))
  val failedDivision = Try(riskyMath(10, 0))

  safeDivision match {
    case Success(value) => println(s"Success: $value")
    case Failure(ex) => println(s"Failure: ${ex.getMessage}")
  }

  failedDivision match {
    case Success(value) => println(s"Success: $value")
    case Failure(ex) => println(s"Failure: ${ex.getMessage}")
  }

  // Option and Try can both use .map, .flatMap, .filter etc.
  val shoutName = user1.map(_.toUpperCase)
  println(s"SHOUTED USER: $shoutName")

  // ⏱ FUTURE — Hello Asynchronous World
  val longCalculation = Future {
    println("Starting long calculation...")
    Thread.sleep(1000)
    println("Done computing")
    42
  }

  println("Main thread keeps going while future computes...")

  // Blocking just for demonstration (don't block in real code!)
  val result = Await.result(longCalculation, 2.seconds)
  println(s"Future result: $result")

  // You can chain Futures
  val futureGreeting = longCalculation.map(value => s"Hello, result is $value!")
  val greetingResult = Await.result(futureGreeting, 2.seconds)
  println(greetingResult)
}
