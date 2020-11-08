package com.freddieposer.scaly.parsing

import com.freddieposer.scaly.parsing.antlr.{ScalyLexer, ScalyParser}
import com.freddieposer.scaly.parsing.parsetree.ParseTree
import org.antlr.v4.runtime.{ANTLRInputStream, CharStreams, CommonTokenStream}

object ScalyParser{

  def parse(text: String): ParseTree = {

    val input = CharStreams.fromString(text)

    val lexer = new ScalyLexer(input)
    val parser = new ScalyParser(new CommonTokenStream(lexer))

    val visitor = new ScalyParsingVisitor

    parser.compilationUnit().accept(visitor)

  }



}
