# Scaly
_Compiling a Scala Inspired Language to CPython Bytecode_

## Project Structure
* `com.freddieposer.scaly`
    * `AST`
    * `typechecker` - The TypeChecker generates an IST for use by the backend compiler 
        * `context`
        * `types`
            * `stdtypes` - Types in the standard library
    * `backend`
        * `pyc` - Code for reading and writing compiled python files
        * `internal` - InternalSyntaxTree (IST) for representing code pre-compilation
    * `utils` - Utility classes
    * `tests` - Simple test suite
    
* `test_suite` - Each file is a single test
    - Files starting with an `S_` are expected to pass, those with an `F_` are expected to fail
    - Files in the `compiler` directory have their expected output at the top in a comment

## Notes
* Targeting CPython 3.8 (latest version supported by anaconda3)
* Parsing is now done by [Scalameta](https://scalameta.org/) instead of ANTLR4