# Scaly
_Compiling a Scala Inspired Language to CPython Bytecode_

## Project Structure
* `com.freddieposer.scaly`
    * `AST`
    * `typechecker`
        * `context`
        * `types`
            * `stdtypes` - Types in the standard library
    * `backend`
        * `pyc` - Code for reading and writing compiled python files
        * `internal` - InternalSyntaxTree (IST) for representing code pre-compilation
    * `utils` - Utility classes

## Notes
* Targeting CPython 3.8 (latest version supported by anaconda3)
* Parsing is now done by [Scalameta](https://scalameta.org/) instead of ANTLR4