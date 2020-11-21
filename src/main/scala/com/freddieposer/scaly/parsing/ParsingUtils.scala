package com.freddieposer.scaly.parsing

import java.util

import com.freddieposer.scaly.parsing.antlr.ScalyParser.{IdsContext, ParamsContext}
import com.freddieposer.scaly.parsing.parsetree.ParseTree
import org.antlr.v4.runtime.ParserRuleContext

import scala.jdk.CollectionConverters.ListHasAsScala

import scala.reflect.internal.FatalError

/**
 * Utilities for dealing with ANTLR4 parse trees in scala
 * @param visit Visit function from a AbstractParseTreeVisitor[R]
 * @tparam R Return type of visit
 */
class ParsingUtils[R](private val visit: org.antlr.v4.runtime.tree.ParseTree => R) {

  // Utility Functions
  /**
   * Implicitly convert from Java {@link util.List} to scala {@link scala.List}
   *
   * @param xs Java list
   * @tparam T List contents type
   * @return xs as Scala list
   */
  implicit def ListToList[T](xs: util.List[T]): List[T] = xs.asScala.toList

  /**
   * Visit a context and cast it to T (UNSAFE)
   * @param ctx
   * @tparam T
   * @return
   */
  def visitAs[T](ctx: ParserRuleContext): T = visit(ctx).asInstanceOf[T]

  //TODO: This violates type safety
  /**
   * Takes a list of contexts, visits the the only one which is not null
   * @param ctxs - a list of context of which only one may be non-null.
   * @tparam T - Type to cast return to
   * @return
   */
  def visitOne[T](ctxs: ParserRuleContext*): T = {
    val vs = ctxs.filterNot(_ == null)
    if (vs.isEmpty) throw new Exception("No non-null contexts for visitOne")
    if (vs.length > 1) throw new Exception("More than one non-null context for visitOne")
    visit(vs.head).asInstanceOf[T]
  }

  /**
   * Deliberate implementation missing
   * @return
   */
  def !!! :Nothing = throw FatalError("This code should be unreachable")
}
