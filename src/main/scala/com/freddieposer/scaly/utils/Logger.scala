package com.freddieposer.scaly.utils


object Logger {

  val debug: String => Unit = printer(Console.WHITE, "DEBUG")
  val log: String => Unit = printer(Console.BLUE, "LOG")
  val warn: String => Unit = printer(Console.YELLOW, "WARN")
  val error: String => Unit = printer(Console.RED, "ERROR")
  val success: String => Unit = printer(Console.GREEN, typ = "SUCCESS")

  private def printer(colour: String, typ: String)(text: String): Unit =
    printInColour(f"[${typ}%7s] $text", colour)

  private def printInColour(text: String, colour: String = Console.WHITE): Unit = {
    println(s"$colour$text${Console.WHITE}")
  }

}

