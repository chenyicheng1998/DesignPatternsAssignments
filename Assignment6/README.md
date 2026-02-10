# Assignment 6: Customizable Printer (Decorator Pattern)

## Overview

This assignment demonstrates the **Decorator Design Pattern** by implementing a customizable printer system in Java. The pattern allows for dynamic addition of behaviors to individual objects without affecting other objects of the same class.

## Project Structure

```
Assignment6/
├── README.md
├── pom.xml
└── src/main/java/
    ├── Printer.java              # Interface
    ├── BasicPrinter.java         # Concrete component
    ├── PrinterDecorator.java     # Abstract decorator
    ├── EncryptedPrinter.java     # Concrete decorator (encryption)
    ├── XMLPrinter.java           # Concrete decorator (XML formatting)
    └── Main.java                 # Demo application
```

## Implementation

### Core Components

1. **`Printer` (Interface)**: Defines the `print(String message)` method

2. **`BasicPrinter`**: Base implementation that prints messages to console

3. **`PrinterDecorator`**: Abstract decorator class that wraps a `Printer` object

### Decorators

1. **`XMLPrinter`**: Wraps messages in XML tags
   - Input: `"Hello World!"` → Output: `"<message>Hello World!</message>"`

2. **`EncryptedPrinter`**: Encrypts messages using Caesar cipher (shift by 3)
   - Input: `"Hello World!"` → Output: `"Khoor Zruog!"`
   - Includes static `decrypt()` method for verification

## Usage Examples

```java
// Basic printer
Printer printer = new BasicPrinter();
printer.print("Hello World!");
// Output: Hello World!

// Single decorator
Printer xmlPrinter = new XMLPrinter(new BasicPrinter());
xmlPrinter.print("Hello World!");
// Output: <message>Hello World!</message>

// Multiple decorators (order matters!)
Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
printer2.print("Hello World!");
// Output: <message>Khoor Zruog!</message>
```

## Running the Application

### Compile
```bash
mvn clean compile
```

### Run
```bash
java -cp target/classes Main
```

## Design Pattern Benefits

- ✅ **Open/Closed Principle**: Add new decorators without modifying existing code
- ✅ **Single Responsibility**: Each decorator has one specific job
- ✅ **Flexible Composition**: Combine decorators in any order at runtime
- ✅ **Transparent Interface**: All decorators implement the same interface

## UML Class Diagram

```
       <<interface>>
          Printer
             △
             │
        ┌────┴────┐
        │         │
   BasicPrinter   │
                  │
          PrinterDecorator (abstract)
                  △
                  │
            ┌─────┴─────┐
            │           │
       XMLPrinter   EncryptedPrinter
```

## Decorator Pattern Flow

When you create: `new EncryptedPrinter(new XMLPrinter(new BasicPrinter()))`

```
Message: "Hello"
    ↓
[EncryptedPrinter] → encrypts to "Khoor"
    ↓
[XMLPrinter] → wraps to "<message>Khoor</message>"
    ↓
[BasicPrinter] → prints: <message>Khoor</message>
```

## Key Features

- **Caesar Cipher Encryption**: Shift by 3, preserves non-letters, fully reversible
- **XML Formatting**: Simple `<message>` tag wrapper
- **Order Matters**: Different decorator orders produce different results
- **Runtime Flexibility**: Add/remove behaviors dynamically

---

**Assignment Requirements**: ✅ All satisfied  
**Status**: Complete and tested

