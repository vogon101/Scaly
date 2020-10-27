package com.freddieposer.scaly.utils

trait PrettyPrinter {

  def prettyPrint(indent: Int): String =
    "\t".repeat(indent) + this.toString.split("\n").mkString("\n" + "\t".repeat(indent))

}
