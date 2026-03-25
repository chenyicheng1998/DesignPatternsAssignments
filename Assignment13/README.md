# Assignment 13: File System Handling (Visitor Pattern)

This assignment models a tiny file system and demonstrates two visitors:

- `SizeCalculatorVisitor` sums file sizes (in MB) while traversing directories.
- `SearchVisitor` collects files that match a given extension (case-insensitive).

## Structure
- `FileSystemElement` – common interface with `accept(FileSystemVisitor)`.
- `File` – leaf node with `name` and `sizeInMb`.
- `Directory` – composite node holding child `FileSystemElement`s.
- `FileSystemVisitor` – visitor interface with `visit(File)` and `visit(Directory)`.
- `SizeCalculatorVisitor` – accumulates total size.
- `SearchVisitor` – accumulates matching files by extension.
- `Main` – builds a sample tree and runs both visitors.

## Run
From the project root:

```bash
mvn -pl Assignment13 -am compile
java -cp Assignment13/target/classes visitor.filesystem.Main
```

