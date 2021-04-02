package com.freddieposer.scaly.backend

import com.freddieposer.scaly.backend.internal.IST_CompilationUnit
import com.freddieposer.scaly.backend.ist_transformers.{ISTTransformerPipeline, PatternMatchingTransformer}
import com.freddieposer.scaly.backend.pyc.PyCodeObject

class ISTCompilationPipeline(val transformers: ISTTransformerPipeline, val compiler: ISTCompiler) {

  def compile(ist: IST_CompilationUnit): PyCodeObject = {
    compiler.compile(transformers.transform(ist))
  }

}

object ISTCompilationPipeline {

  def standard(filename: String) =
    new ISTCompilationPipeline(
      new ISTTransformerPipeline(
        new PatternMatchingTransformer
      ), new ISTCompiler(filename)
    )

}
