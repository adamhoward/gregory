# gregory

A polyglot experiment.

A long time ago I read a great article in Server/Workstation Expert 
entitled [_High-School Algebra, Backwards_](http://alumnus.caltech.edu/~copeland/work/PDF/2001-02-poly.pdf). In 
it the authors introduce Gregory's Theorem, a method for computing 
polynomials from an integer sequence. A perl implementation is provided.

Now, whenever I am learning a new programming language, one of the first 
things I try to implement is a solver for Gregory's Theorem. It's simple 
enough in theory that all of my time can be spent on finding the most 
idiomatic way to express the solution for each language.

Some of the things I get to play with:
* Implement factorial
* Implement a new datatype
* Functions to operate on that new datatype
* Syntatcitc sugar for data structures
* Iteration v. recursion v. declarativityness

## Usage
For Java, run `mvn test`  
For Clojure, run `lein repl`  
For Python, cd to `src/main/python/gregory` and run `python -i GregoryTests.py`

