# DataStructures

This repository contains independent Java examples organized by topic under `src`.

## Requirements

- JDK 21 or later (`java` and `javac` on your `PATH`)
- Bash

## Compile and run a class

From the repository directory, run `run.sh` with the class's fully qualified name
(its package followed by its class name):

```sh
./run.sh array.LinearSearch
```

The script compiles all source files into `build/classes` and launches the
requested class. Programs that read from standard input accept input in the same
terminal; for example, `LinearSearch` waits for an integer to search for.

To pass command-line arguments to a class, put them after its name:

```sh
./run.sh some.package.ClassName arg1 arg2
```
