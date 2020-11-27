package com.freddieposer.scaly.typechecker

import com.freddieposer.scaly.AST.ScalyAST

case class TypeError(message: String, node: ScalyAST)
