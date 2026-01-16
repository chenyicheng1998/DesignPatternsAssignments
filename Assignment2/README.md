# ASCII Art User Interface - Abstract Factory Pattern

## 📋 Table of Contents
- [Overview](#overview)
- [Quick Start](#quick-start)
- [Design Pattern](#design-pattern)
- [Class Structure](#class-structure)
- [Class Diagram](#class-diagram)
- [Usage Examples](#usage-examples)
- [Visual Styles](#visual-styles)
- [Requirements Checklist](#requirements-checklist)
- [Design Highlights](#design-highlights)
- [Testing Results](#testing-results)
- [Files Overview](#files-overview)

---

## Overview

This assignment implements a simple ASCII art-based user interface element creation factory using the **Abstract Factory design pattern** in Java. The application provides two different 'look-and-feel' styles for UI elements.

**Location:** `C:\Users\cheny\IdeaProjects\DesignPatternsAssignments\Assignment2\src\main\java`

---

## Quick Start

### Compile and Run
```powershell
cd C:\Users\cheny\IdeaProjects\DesignPatternsAssignments\Assignment2\src\main\java
javac *.java
java Main
```

### Expected Output
The program demonstrates:
1. Creating and displaying UI elements with Style A (Classic Rectangular)
2. Creating and displaying UI elements with Style B (Rounded Decorative)
3. Dynamically changing element content using `setText()` and displaying the updated elements

---

## Design Pattern

### Abstract Factory Pattern

The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

**Pattern Benefits:**
- ✅ **Consistency**: All elements from one factory have matching style
- ✅ **Flexibility**: Easy to switch between styles by changing the factory
- ✅ **Extensibility**: Add new styles without changing existing code
- ✅ **Encapsulation**: Creation logic is encapsulated in factory classes
- ✅ **Single Responsibility**: Each class has one clear purpose

---

## Class Structure

### Abstract Classes
- **Button**: Base class for all button UI elements
- **TextField**: Base class for all text field UI elements
- **Checkbox**: Base class for all checkbox UI elements

Each abstract class:
- Declares an abstract `display()` method
- Implements a `setText(String text)` method for dynamic content updates
- Implements a `getText()` method to retrieve current text
- Stores the text content in a protected field

### Concrete Implementations - Style A (Classic Rectangular)
- **ButtonA**: Uses '=' for borders with centered text
- **TextFieldA**: Uses '-' for borders with left-aligned text
- **CheckboxA**: Uses '[ ]' for checkbox with '+' border

Example output:
```
============
=  Submit  =
============
```

### Concrete Implementations - Style B (Rounded Decorative)
- **ButtonB**: Uses '*' for borders with decorative '< >' around text
- **TextFieldB**: Uses '~' for borders with parentheses
- **CheckboxB**: Uses '( )' for checkbox with decorative border

Example output:
```
 ************
*  < Cancel >  *
 ************
```

### Factory Classes
- **UIFactory** (Abstract): Defines methods for creating UI elements:
  - `createButton(String text)`
  - `createTextField(String text)`
  - `createCheckbox(String text)`

- **AFactory** (Concrete): Creates Style A UI elements
- **BFactory** (Concrete): Creates Style B UI elements

### Main Application
- **Main**: Demonstrates the factory pattern by:
  1. Creating UI elements using AFactory (Style A)
  2. Creating UI elements using BFactory (Style B)
  3. Demonstrating dynamic content updates using `setText()`

---

## Class Diagram

### Factory Hierarchy
```
                        ┌─────────────┐
                        │  UIFactory  │ (Abstract)
                        ├─────────────┤
                        │ +createButton(text): Button
                        │ +createTextField(text): TextField
                        │ +createCheckbox(text): Checkbox
                        └──────┬──────┘
                               │
              ┌────────────────┴────────────────┐
              │                                 │
        ┌─────▼─────┐                    ┌─────▼─────┐
        │ AFactory  │                    │ BFactory  │
        ├───────────┤                    ├───────────┤
        │ +createButton(text): ButtonA   │ +createButton(text): ButtonB
        │ +createTextField(text): TextFieldA │ +createTextField(text): TextFieldB
        │ +createCheckbox(text): CheckboxA │ +createCheckbox(text): CheckboxB
        └───────────┘                    └───────────┘
```

### UI Element Hierarchy
```
┌───────────┐              ┌────────────┐              ┌───────────┐
│  Button   │ (Abstract)   │ TextField  │ (Abstract)   │ Checkbox  │ (Abstract)
├───────────┤              ├────────────┤              ├───────────┤
│ #text: String            │ #text: String             │ #text: String
│ +display(): void         │ +display(): void          │ +display(): void
│ +setText(text): void     │ +setText(text): void      │ +setText(text): void
│ +getText(): String       │ +getText(): String        │ +getText(): String
└─────┬─────┘              └──────┬─────┘              └─────┬─────┘
      │                           │                           │
  ┌───┴───┐                   ┌───┴────┐                 ┌────┴────┐
  │       │                   │        │                 │         │
┌─▼──┐  ┌─▼──┐           ┌────▼───┐ ┌──▼─────┐     ┌────▼────┐ ┌──▼─────┐
│ButtonA ButtonB│         │TextFieldA TextFieldB│    │CheckboxA  CheckboxB│
├────┤  ├────┤           ├────────┤ ├────────┤     ├─────────┤ ├────────┤
│+display()  +display()│ │+display()  +display()│   │+display() +display()│
│(Style A)   (Style B)│ │(Style A)   (Style B)│   │(Style A)  (Style B)│
└────┘  └────┘           └────────┘ └────────┘     └─────────┘ └────────┘
```

### Relationships
- **Inheritance**: ButtonA/B extend Button, TextFieldA/B extend TextField, CheckboxA/B extend Checkbox
- **Factory Pattern**: AFactory creates Style A elements, BFactory creates Style B elements
- **Dependency**: Concrete factories create and return concrete UI elements

---

## Usage Examples

### Create Style A UI Elements
```java
UIFactory factoryA = new AFactory();
Button button = factoryA.createButton("Click Me");
TextField textField = factoryA.createTextField("Enter text");
Checkbox checkbox = factoryA.createCheckbox("I agree");

button.display();
textField.display();
checkbox.display();
```

### Create Style B UI Elements
```java
UIFactory factoryB = new BFactory();
Button button = factoryB.createButton("Submit");
TextField textField = factoryB.createTextField("Search");
Checkbox checkbox = factoryB.createCheckbox("Remember me");

button.display();
textField.display();
checkbox.display();
```

### Update Element Content
```java
Button button = factoryA.createButton("Original");
button.display();  // Shows "Original"

button.setText("Updated");
button.display();  // Shows "Updated"
```

### Switch Between Styles
```java
// Start with Style A
UIFactory factory = new AFactory();
Button button = factory.createButton("Submit");
button.display();  // Shows Style A button

// Switch to Style B - just change the factory
factory = new BFactory();
button = factory.createButton("Submit");
button.display();  // Shows Style B button
```

---

## Visual Styles

### Style A (Classic Rectangular)
```
Button:
============
=  Submit  =
============

TextField:
--------------------
| Enter your name  |
--------------------

Checkbox:
+---------+
| [ ] Accept Terms
+---------+
```

### Style B (Rounded Decorative)
```
Button:
 ************
*  < Submit >  *
 ************

TextField:
 ~~~~~~~~~~~~~~~~~~~~
( Enter your name  )
 ~~~~~~~~~~~~~~~~~~~~

Checkbox:
  .~~~~~~~~~.
 /  ( ) Accept Terms
  '~~~~~~~~~'
```

---

## Requirements Checklist

✅ **1. Abstract classes with display() method**
- Button, TextField, and Checkbox classes define abstract `display()` method

✅ **2. Style A concrete classes**
- ButtonA, TextFieldA, CheckboxA implement Style A (Classic Rectangular)
- Uses '=', '-', and '+' characters for borders

✅ **3. Style B concrete classes**
- ButtonB, TextFieldB, CheckboxB implement Style B (Rounded Decorative)
- Uses '*', '~', and decorative characters for borders

✅ **4. Abstract factory class**
- UIFactory defines methods: `createButton(text)`, `createTextField(text)`, `createCheckbox(text)`
- All methods take String parameter for text content

✅ **5. Concrete factory classes**
- AFactory creates Style A elements only
- BFactory creates Style B elements only
- Each creation method accepts String parameter and returns appropriate type

✅ **6. Main method demonstration**
- Creates factories and uses them to create UI elements
- Demonstrates both Style A and Style B

✅ **7. Dynamic content updates**
- `setText()` method implemented in abstract base classes
- Changes are visible when `display()` is called next
- Method is defined in abstract classes as it's common to all elements
- Concrete classes inherit this functionality

---

## Design Highlights

### 1. setText() Method Placement
The `setText()` method is implemented in the **abstract base classes** (Button, TextField, Checkbox) because:
- It's common functionality shared by all UI elements
- It operates on the `text` field which is defined in the abstract class
- This follows the **DRY (Don't Repeat Yourself)** principle
- Concrete classes automatically inherit this behavior
- Avoids code duplication across 6 concrete classes

### 2. Constructor Parameter
All creation methods in UIFactory take a `String text` parameter, allowing initial text to be set when creating elements.

### 3. Display Method
The `display()` method is abstract in the base classes and implemented differently in each concrete class to provide the distinct ASCII art styles.

### 4. Pattern Benefits
- **Open/Closed Principle**: New UI styles can be added by creating new concrete classes and factories without modifying existing code
- **Consistency**: Factories ensure all UI elements in a family have consistent styling
- **Flexibility**: Easy to switch between different UI styles by changing the factory
- **Maintainability**: Clear separation between abstract interfaces and concrete implementations

---

## Testing Results

✅ **Compilation successful** - No errors  
✅ **Program runs successfully**  
✅ **All UI elements display correctly**  
✅ **setText() functionality works as expected**  
✅ **Both factories create appropriate style elements**  
✅ **Style consistency maintained within each factory**  

---

## Files Overview

### Core Classes (13 Java files)

| File | Purpose |
|------|---------|
| **Button.java** | Abstract base class for buttons |
| **TextField.java** | Abstract base class for text fields |
| **Checkbox.java** | Abstract base class for checkboxes |
| **ButtonA.java** | Style A button implementation |
| **TextFieldA.java** | Style A text field implementation |
| **CheckboxA.java** | Style A checkbox implementation |
| **ButtonB.java** | Style B button implementation |
| **TextFieldB.java** | Style B text field implementation |
| **CheckboxB.java** | Style B checkbox implementation |
| **UIFactory.java** | Abstract factory class |
| **AFactory.java** | Factory for Style A elements |
| **BFactory.java** | Factory for Style B elements |
| **Main.java** | Demonstration program |

### Additional Files

| File | Purpose |
|------|---------|
| **ExtensionExample.java** | Example showing how to add a third style (Style C) |
| **README.md** | This comprehensive documentation |

---

## Key Methods Reference

| Method | Description |
|--------|-------------|
| `createButton(String text)` | Factory method to create a button with specified text |
| `createTextField(String text)` | Factory method to create a text field with specified text |
| `createCheckbox(String text)` | Factory method to create a checkbox with specified label |
| `display()` | Display the UI element using ASCII art (implemented in concrete classes) |
| `setText(String text)` | Update the element's text content dynamically |
| `getText()` | Get the current text content of the element |

---

## Summary

This implementation fully satisfies all assignment requirements and demonstrates proper use of the **Abstract Factory design pattern** with ASCII art UI elements. 

**Key Achievements:**
- Clean, well-documented, and easily extensible code
- Two distinct visual styles with consistent implementation
- Proper object-oriented design principles
- Dynamic content update capability
- Comprehensive demonstration program

The code follows SOLID principles and is ready for future enhancements, such as adding additional UI styles or element types.
