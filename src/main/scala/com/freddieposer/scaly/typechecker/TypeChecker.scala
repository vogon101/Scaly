package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST.{CompilationUnit, ScalyClassDef, ScalyObjectDef}
import com.freddieposer.scaly.typechecker.context.{EmptyTypeContext, TypeContext}
import com.freddieposer.scaly.typechecker.types.{ScalyASTClassType, ScalyPlaceholderTypeName}

class TypeChecker(
                 val ast: CompilationUnit
                 ) {

  lazy val globalContext: TypeContext = {
    var _gc: TypeContext = EmptyTypeContext
    ast.statements.foreach {
      case c @ ScalyClassDef(id, parents, _, _) =>
        _gc = _gc addType (id -> ScalyASTClassType(id, parents.headOption.map(ScalyPlaceholderTypeName), c))
      case ScalyObjectDef(id, parents, body) => ???
    }
    _gc
  }

}
