# Organization Structure - Composite Design Pattern

## 📋 Table of Contents
- [Overview](#overview)
- [Quick Start](#quick-start)
- [Design Pattern](#design-pattern)
- [Class Structure](#class-structure)
- [Class Diagram](#class-diagram)
- [XML Format](#xml-format)
- [Requirements Checklist](#requirements-checklist)
- [Usage Examples](#usage-examples)
- [Key Features](#key-features)
- [Design Highlights](#design-highlights)
- [Sample Output](#sample-output)
- [Files Overview](#files-overview)

---

## Overview

This assignment implements an organizational structure management system using the **Composite design pattern** in Java. The application allows you to build, manage, and analyze hierarchical organization structures consisting of departments and employees.

**Location:** `C:\Users\cheny\IdeaProjects\DesignPatternsAssignments\Assignment3\src\main\java`

---

## Quick Start

### Compile and Run
```powershell
cd C:\Users\cheny\IdeaProjects\DesignPatternsAssignments\Assignment3\src\main\java
javac *.java
java Main
```

### Expected Output
The program demonstrates:
1. Creating a hierarchical organization structure with departments and employees
2. Calculating total salaries at various levels (entire company, departments, sub-departments)
3. Displaying the organization structure in XML format
4. Adding and removing departments and employees dynamically

---

## Design Pattern

### Composite Pattern

The Composite pattern allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.

**Key Benefits:**
- ✅ **Uniform Treatment**: Departments and employees are treated uniformly through a common interface
- ✅ **Recursive Composition**: Departments can contain other departments (nested structure)
- ✅ **Flexibility**: Easy to add new components at any level
- ✅ **Simplicity**: Single method calls work on entire tree structures
- ✅ **Open/Closed Principle**: New component types can be added without modifying existing code

**Pattern Structure:**
- **Component** (`OrganizationComponent`): Abstract base class defining common interface
- **Composite** (`Department`): Can contain other components (departments and employees)
- **Leaf** (`Employee`): Cannot contain other components

---

## Class Structure

### OrganizationComponent (Abstract Component)
The abstract base class that defines the common interface for all organization components.

**Key Methods:**
- `add(OrganizationComponent component)`: Add a component (abstract)
- `remove(OrganizationComponent component)`: Remove a component (abstract)
- `getTotalSalary()`: Calculate total salary (abstract)
- `printXML(int indent)`: Print in XML format (abstract)
- `getName()`: Get the component name
- `getIndent(int level)`: Helper for XML formatting

### Department (Composite)
Represents a department that can contain both employees and other departments.

**Features:**
- Maintains a list of child components
- Can add/remove components at runtime
- Calculates total salary by summing all child salaries
- Prints XML with nested structure
- Supports unlimited nesting depth

**Key Methods:**
```java
public void add(OrganizationComponent component)
public void remove(OrganizationComponent component)
public double getTotalSalary()
public void printXML(int indent)
public OrganizationComponent getComponent(int index)
public List<OrganizationComponent> getComponents()
```

### Employee (Leaf)
Represents an individual employee in the organization.

**Attributes:**
- `name`: Employee name
- `salary`: Employee salary

**Features:**
- Cannot contain other components (leaf node)
- Returns own salary for `getTotalSalary()`
- Prints as single-line XML element
- Throws `UnsupportedOperationException` for add/remove operations

**Key Methods:**
```java
public Employee(String name, double salary)
public double getSalary()
public void setSalary(double salary)
public double getTotalSalary()
public void printXML(int indent)
```

---

## Class Diagram

### Composite Pattern Structure
```
                    ┌───────────────────────┐
                    │ OrganizationComponent │ (Abstract)
                    ├───────────────────────┤
                    │ #name: String         │
                    ├───────────────────────┤
                    │ +getName(): String    │
                    │ +add(component): void │
                    │ +remove(component): void │
                    │ +getTotalSalary(): double │
                    │ +printXML(indent): void │
                    └──────────┬────────────┘
                               │
                ┌──────────────┴──────────────┐
                │                             │
    ┌───────────▼──────────┐     ┌───────────▼──────────┐
    │     Department       │     │      Employee        │
    │    (Composite)       │     │       (Leaf)         │
    ├──────────────────────┤     ├──────────────────────┤
    │ -components: List    │     │ -salary: double      │
    ├──────────────────────┤     ├──────────────────────┤
    │ +add(component)      │     │ +getSalary(): double │
    │ +remove(component)   │     │ +setSalary(double)   │
    │ +getTotalSalary()    │     │ +getTotalSalary()    │
    │ +printXML(indent)    │     │ +printXML(indent)    │
    │ +getComponent(int)   │     │ +add() throws Ex     │
    │ +getComponents()     │     │ +remove() throws Ex  │
    └──────────────────────┘     └──────────────────────┘
            │
            │ contains 0..*
            ▼
    ┌───────────────────┐
    │OrganizationComponent│
    └───────────────────┘
```

### Relationships
- **Inheritance**: `Department` and `Employee` both extend `OrganizationComponent`
- **Composition**: `Department` contains a list of `OrganizationComponent` objects
- **Recursive Structure**: A `Department` can contain other `Department` objects, enabling tree structures

---

## XML Format

The organization structure is printed in XML format with proper indentation to reflect the hierarchy.

### XML Design Decisions
- **Departments**: Use opening and closing tags with nested content
- **Employees**: Use self-closing tags (no children)
- **Attributes**: Name and salary stored as XML attributes
- **Indentation**: Two spaces per nesting level for readability

### Example XML Output
```xml
<Department name="TechCorp">
  <Department name="Engineering">
    <Department name="Software Development">
      <Employee name="Alice Johnson" salary="85000.0" />
      <Employee name="Bob Smith" salary="90000.0" />
      <Employee name="Carol White" salary="95000.0" />
    </Department>
    <Department name="Quality Assurance">
      <Employee name="David Brown" salary="70000.0" />
      <Employee name="Eve Davis" salary="72000.0" />
    </Department>
  </Department>
  <Department name="Sales">
    <Employee name="Frank Miller" salary="65000.0" />
    <Employee name="Grace Wilson" salary="68000.0" />
  </Department>
</Department>
```

---

## Requirements Checklist

✅ **1. Organization consists of departments and employees**
- `Department` class represents departments
- `Employee` class represents employees

✅ **2. Departments can contain other departments and employees**
- `Department` extends `OrganizationComponent` and maintains a list of children
- Supports unlimited nesting depth

✅ **3. Departments and employees can be added at any time**
- `add()` method allows adding components dynamically
- Demonstrated in Main class with runtime additions

✅ **4. Department has a name**
- `name` field in `OrganizationComponent` base class
- Accessible via `getName()` method

✅ **5. Employee has name and salary**
- `name` field inherited from `OrganizationComponent`
- `salary` field specific to `Employee` class
- Getters and setters provided

✅ **6. Components can be added/removed with single method calls**
- `add(OrganizationComponent component)` - single method call
- `remove(OrganizationComponent component)` - single method call

✅ **7. Print total salary with single method call**
- `getTotalSalary()` method works at any level
- Recursively calculates sum of all employee salaries

✅ **8. Print organization structure in XML format**
- `printXML(int indent)` method
- Reflects hierarchical structure with proper indentation
- Uses XML elements and attributes

✅ **9. Main class with main() method**
- `Main.java` with comprehensive demonstration
- Shows all key functionality

---

## Usage Examples

### Create Organization Structure
```java
// Create departments
Department company = new Department("TechCorp");
Department engineering = new Department("Engineering");
Department sales = new Department("Sales");

// Create employees
Employee emp1 = new Employee("Alice Johnson", 85000);
Employee emp2 = new Employee("Bob Smith", 90000);

// Build hierarchy
engineering.add(emp1);
engineering.add(emp2);
company.add(engineering);
company.add(sales);
```

### Calculate Total Salary
```java
// Get total salary for entire company
double totalSalary = company.getTotalSalary();
System.out.println("Total: $" + totalSalary);

// Get total for specific department
double deptSalary = engineering.getTotalSalary();
System.out.println("Engineering: $" + deptSalary);
```

### Print Organization Structure
```java
// Print entire structure in XML format
company.printXML(0);
```

### Add Components Dynamically
```java
// Add new employee to existing department
Employee newEmp = new Employee("Carol White", 95000);
engineering.add(newEmp);

// Add new department
Department marketing = new Department("Marketing");
company.add(marketing);
```

### Remove Components
```java
// Remove an employee from department
sales.remove(emp1);

// Remove entire department
company.remove(marketing);
```

### Access Individual Components
```java
// Get specific component by index
OrganizationComponent component = engineering.getComponent(0);

// Get all components
List<OrganizationComponent> components = engineering.getComponents();
```

---

## Key Features

### 1. Hierarchical Structure
- Unlimited nesting depth
- Departments within departments within departments...
- Natural representation of real organizational structures

### 2. Uniform Treatment
- Both departments and employees implement the same interface
- Client code doesn't need to distinguish between leaf and composite

### 3. Recursive Operations
- `getTotalSalary()` recursively sums all employee salaries in tree
- `printXML()` recursively prints entire structure

### 4. Type Safety
- Employees throw exceptions if you try to add children
- Clear error messages for unsupported operations

### 5. Flexible Management
- Add components at any time
- Remove components at any time
- No structural limitations

---

## Design Highlights

### 1. Abstract Base Class
`OrganizationComponent` provides common interface for both departments and employees:
- Defines contract that all components must follow
- Provides shared functionality (name management, indent helper)
- Enables uniform treatment through polymorphism

### 2. Composite Pattern Implementation
Perfect example of the Composite pattern:
- **Component**: `OrganizationComponent`
- **Composite**: `Department` (can contain children)
- **Leaf**: `Employee` (cannot contain children)

### 3. Exception Handling
Employees throw `UnsupportedOperationException` for composite operations:
- Clear indication that operation is not supported
- Prevents incorrect usage at runtime
- Better than silently ignoring invalid operations

### 4. XML Generation
Elegant recursive XML printing:
- Proper indentation reflects structure
- Clean, readable output
- Uses standard XML syntax

### 5. Encapsulation
- Components list in `Department` is private
- Access only through controlled methods
- Protects internal structure

---

## Sample Output

```
========================================
Organization Structure - Composite Pattern Demo
========================================

=== Organization Structure in XML Format ===

<Department name="TechCorp">
  <Department name="Engineering">
    <Department name="Software Development">
      <Employee name="Alice Johnson" salary="85000.0" />
      <Employee name="Bob Smith" salary="90000.0" />
      <Employee name="Carol White" salary="95000.0" />
    </Department>
    <Department name="Quality Assurance">
      <Employee name="David Brown" salary="70000.0" />
      <Employee name="Eve Davis" salary="72000.0" />
    </Department>
  </Department>
  <Department name="Sales">
    <Employee name="Frank Miller" salary="65000.0" />
    <Employee name="Grace Wilson" salary="68000.0" />
    <Employee name="Henry Taylor" salary="71000.0" />
  </Department>
  <Department name="Human Resources">
    <Employee name="Iris Anderson" salary="62000.0" />
    <Employee name="Jack Thomas" salary="64000.0" />
  </Department>
</Department>

=== Total Salary Calculations ===

Total salary for TechCorp: $742000.00
Total salary for Engineering: $412000.00
Total salary for Software Development: $270000.00
Total salary for Sales: $204000.00
Total salary for Human Resources: $126000.00

=== Dynamic Operations Demo ===

Adding a new employee to Sales department...
New total salary for Sales: $270000.00

Removing an employee from HR department...
New total salary for HR: $62000.00

Adding a new department to the company...
Total salary for Marketing: $148000.00

=== Final Organization Total Salary ===

Total salary for TechCorp: $892000.00
```

---

## Files Overview

### Core Classes (4 Java files)

| File | Purpose |
|------|---------|
| **OrganizationComponent.java** | Abstract base class for all components (Component in pattern) |
| **Department.java** | Composite class that can contain other components |
| **Employee.java** | Leaf class representing individual employees |
| **Main.java** | Demonstration program showing all functionality |

### File Descriptions

#### OrganizationComponent.java (51 lines)
- Abstract base class defining common interface
- Declares abstract methods: `add()`, `remove()`, `getTotalSalary()`, `printXML()`
- Provides concrete methods: `getName()`, `getIndent()`
- Enables polymorphic treatment of all components

#### Department.java (60 lines)
- Implements composite behavior
- Maintains ArrayList of child components
- Implements all abstract methods from base class
- Provides additional methods: `getComponent()`, `getComponents()`
- Recursive salary calculation and XML printing

#### Employee.java (43 lines)
- Implements leaf behavior
- Contains salary field
- Throws exceptions for composite operations
- Simple implementations of `getTotalSalary()` and `printXML()`

#### Main.java (141 lines)
- Comprehensive demonstration program
- Creates complex organization structure
- Shows salary calculations at various levels
- Demonstrates dynamic add/remove operations
- Displays XML output before and after modifications

---

## Key Methods Reference

| Method | Class | Description |
|--------|-------|-------------|
| `add(OrganizationComponent)` | OrganizationComponent | Add a child component (abstract) |
| `remove(OrganizationComponent)` | OrganizationComponent | Remove a child component (abstract) |
| `getTotalSalary()` | OrganizationComponent | Get total salary recursively (abstract) |
| `printXML(int)` | OrganizationComponent | Print structure in XML format (abstract) |
| `getName()` | OrganizationComponent | Get component name |
| `getComponent(int)` | Department | Get child at specific index |
| `getComponents()` | Department | Get all children as list |
| `getSalary()` | Employee | Get employee salary |
| `setSalary(double)` | Employee | Set employee salary |

---

## Design Pattern Benefits

### Why Composite Pattern?

1. **Transparency**: Clients can treat individual objects and compositions uniformly
2. **Flexibility**: Easy to add new component types
3. **Simplicity**: Complex tree structures handled with simple code
4. **Recursive Operations**: Operations like `getTotalSalary()` work at any level
5. **Natural Representation**: Tree structure matches real organizational hierarchies

### Real-World Applications

- **File Systems**: Files and folders
- **GUI Components**: Windows containing panels containing widgets
- **Document Structures**: Chapters containing sections containing paragraphs
- **Organization Charts**: Companies, departments, teams, employees
- **Menu Systems**: Menus containing submenus containing menu items

---

## Summary

This implementation fully satisfies all assignment requirements and demonstrates proper use of the **Composite design pattern** for representing organizational structures.

**Key Achievements:**
- ✅ Clean, hierarchical organization structure
- ✅ Uniform treatment of departments and employees
- ✅ Recursive salary calculation
- ✅ XML output with proper formatting
- ✅ Dynamic add/remove operations
- ✅ Comprehensive demonstration program
- ✅ Well-documented, maintainable code

**Design Excellence:**
- Follows SOLID principles
- Proper abstraction and encapsulation
- Type-safe with clear error handling
- Easily extensible for future requirements
- Production-ready code quality

The Composite pattern is an excellent choice for this problem because it naturally represents the part-whole hierarchy of an organization and allows uniform treatment of individual employees and entire departments.
