# Scaly
_Compiling a Scala Inspired Language to CPython Bytecode_

## Command Line Usage
The command line application (`scaly.application.Compiler`) can be compiled to a jar file with `sbt assembly`.

```
scaly 0.1
Usage: scaly [run] [options] <input file>

  <input file>      Location of source file (required)
  -o, --out <file>  Output file - default is in file name with .pyc extension
  --help            Prints the usage text
Command: run
Run the program after compilation, requires python
````

## Project Structure
* `com.freddieposer.scaly`
    * `application`
    * `AST`
    * `backend`
      * `pyc` - Code for reading and writing compiled python files
      * `internal` - InternalSyntaxTree (IST) for representing code pre-compilation
    * `typechecker` - The TypeChecker generates an IST for use by the backend compiler 
        * `context`
        * `types`
            * `stdtypes` - Types in the standard library
    * `utils` - Utility classes
    * `tests` - Simple test suite
    
* `test_suite` - Each file is a single test
    - Files starting with an `S_` are expected to pass, those with an `F_` are expected to fail
    - Files in the `compiler` directory have their expected output at the top in a comment

## Notes
* Targeting CPython 3.8 (latest version supported by anaconda3)
