# Scaly
_Compiling a Scala Inspired Language to CPython Bytecode_

## Project Structure
* `com.freddieposer.scaly`
    * `AST`
    * `backend`
        * `pyc` - Code for reading and writing compiled python files
    * `parsing`
        * `parsetree` - An AST representing the parsed program
        * `antlr` _(Java)_ - ANTLR4 generated code
    * `utils` - Utility classes

## Notes
* Targeting CPython 3.8 (latest version supported by anaconda3)
