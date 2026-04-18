# Assignment 18: Book Recommendations System

## Overview

This project implements a book recommendation system using the **Prototype design pattern**. The system allows users to manage book recommendations for different target audiences by creating new lists from scratch or by cloning and modifying existing ones.

## Design Pattern: Prototype

The Prototype pattern is used to create new objects by cloning existing ones, which is especially useful when:
- Object creation is expensive
- You want to create objects similar to existing ones with slight modifications
- You need to avoid complex initialization code

## Implementation

### Classes

#### 1. `Book` Class
Represents a book with the following attributes:
- `title` (String)
- `author` (String)
- `genre` (String)
- `publicationYear` (int)

Implements `Cloneable` interface to support shallow copying of book objects.

#### 2. `Recommendation` Class
Represents a book recommendation list with:
- `targetAudience` (String) - the intended reader group
- `books` (List<Book>) - collection of recommended books

Implements `Cloneable` interface with **deep cloning** to ensure that:
- The list of books is copied, not just referenced
- Each book in the list is cloned independently

**Key methods:**
- `clone()` - creates a deep copy of the recommendation
- `addBook(Book)` - adds a book to the list
- `removeBook(int)` - removes a book by index
- `setTargetAudience(String)` - modifies the target audience

#### 3. `Main` Class
Provides a command-line interface for interacting with the system.

## Features

The system supports the following operations:

1. **View all recommendations** - List all saved recommendation lists
2. **Create new recommendation** - Build a recommendation list from scratch
3. **Clone and modify** - Clone an existing recommendation and modify it
4. **View details** - Display complete information about a recommendation

## Sample Data

The system initializes with three pre-configured recommendations:
- **Young Adults** - Fantasy and dystopian novels
- **Mystery Lovers** - Thriller and mystery books
- **Science Fiction Fans** - Classic and modern sci-fi

## How to Run

```bash
javac *.java
java Main
```

## Usage Example

1. Select option 3 to clone an existing recommendation
2. Choose "Young Adults" recommendation
3. Change target audience to "Teenagers"
4. Add or remove books as needed
5. Save the new recommendation

The cloned recommendation is independent of the original - modifications to one do not affect the other.

## Pattern Implementation Details

### Deep Cloning
The `Recommendation.clone()` method implements deep cloning:

```java
public Recommendation clone() {
    Recommendation cloned = (Recommendation) super.clone();
    cloned.books = new ArrayList<>();
    for (Book book : this.books) {
        cloned.books.add(book.clone());
    }
    return cloned;
}
```

This ensures:
- A new `ArrayList` is created for the cloned recommendation
- Each `Book` object is cloned individually
- Changes to books in one recommendation don't affect others

### Benefits of This Approach

1. **Flexibility** - Easy to create variations of existing recommendations
2. **Efficiency** - Avoid recreating similar recommendations from scratch
3. **Independence** - Cloned objects are fully independent
4. **Maintainability** - Clear separation of concerns between Book and Recommendation

