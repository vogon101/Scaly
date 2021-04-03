package com.freddieposer.scaly.backend.ist_transformers

import com.freddieposer.scaly.backend.internal.IST_CompilationUnit

class ISTTransformerPipeline(val transformers: ISTExprTransformer*) {

  def transform(ist: IST_CompilationUnit): IST_CompilationUnit =
    transformers.foldLeft(ist) { case (cu, transformer) => transformer.transform(cu) }

}
