# Logger System - Singleton Design Pattern

## Project Overview

This project implements a Logger system based on the Singleton design pattern. The system ensures that only one Logger instance exists throughout the application, with all log messages written to the same file.

## Design Pattern

**Singleton Pattern**

The Singleton pattern is a creational design pattern that ensures a class has only one instance and provides a global access point to it.

### Why Use Singleton?

Reasons for using the Singleton pattern in a logging system:
- **Uniqueness**: Ensures only one Logger instance exists, avoiding multiple log files
- **Global Access**: Any part of the application can access the same Logger instance
- **Resource Management**: Prevents multiple threads from opening the same file simultaneously, which would cause conflicts
- **Consistency**: All log messages are written to the same file, making analysis easier

## Project Structure

```
Assignment5/
├── src/
│   └── main/
│       └── java/
│           └── singleton/
│               └── logger/
│                   ├── logs/                # Log files directory (auto-created)
│                   │   ├── default_log.txt
│                   │   └── new_log.txt
│                   ├── .gitignore          # Git ignore file
│                   ├── Logger.java         # Singleton Logger class
│                   └── Main.java           # Example usage code
├── pom.xml                                 # Maven configuration
└── README.md                               # This file
```

## Core Features

### Logger Class

#### Key Characteristics:
1. **Private Constructor**: Prevents external instantiation
2. **Static Instance**: Holds the unique Logger instance
3. **Thread Safety**: Uses `synchronized` keyword to ensure safety in multi-threaded environments
4. **Exception Handling**: All I/O operations include try-catch blocks

#### Main Methods:

| Method | Description |
|--------|-------------|
| `getInstance()` | Gets the unique Logger instance (lazy loading) |
| `write(String message)` | Writes a log message to file |
| `setFileName(String fileName)` | Dynamically changes the log file name |
| `close()` | Closes the log file and releases resources |

## Usage Example

```java
public class Main {
    public static void main(String[] args) {
        // Get Logger instance
        Logger logger = Logger.getInstance();
        
        // Change log file name (optional)
        logger.setFileName("new_log.txt");
        
        // Write log messages
        logger.write("Simulation started");
        logger.write("Processing data...");
        logger.write("Simulation finished");
        
        // Close Logger (important!)
        logger.close();
    }
}
```

## Running the Program

### Prerequisites
- Java 17 or higher
- Maven (if using a Maven project)

### Compile and Run

#### Using IntelliJ IDEA:
1. Place the code in the `src/main/java/singleton/logger/` directory
2. Right-click on `Main.java`
3. Select "Run 'Main.main()'"

#### Using Command Line:
```bash
# Compile
javac singleton/logger/*.java

# Run
java singleton.logger.Main
```

## Output Description

After running the program, you will see console output similar to:

```
Log directory created: logs
Logger initialized with file: logs/default_log.txt
Logger initialized with file: logs/new_log.txt
Log file changed to: logs/new_log.txt
Logger closed.
```

### Output Explanation:
1. **First line**: The `logs` directory is created if it doesn't exist
2. **Second line**: Logger instance is created with the default file name
3. **Third line**: A new file is opened when `setFileName()` is called
4. **Fourth line**: Confirms the file name has been changed
5. **Fifth line**: Logger is properly closed

At the same time, a `new_log.txt` file will be created in the `logs` folder in the project root directory, containing:
```
Simulation started
Processing data...
Simulation finished
```

### File Structure:
```
DesignPatternsAssignments/
└── Assignment5/
    ├── src/
    │   └── main/
    │       └── java/
    │           └── singleton/
    │               └── logger/
    │                   ├── logs/        ← Log files directory
    │                   │   ├── default_log.txt
    │                   │   └── new_log.txt
    │                   ├── .gitignore
    │                   ├── Logger.java
    │                   └── Main.java
    ├── pom.xml
    └── README.md
```

## Technical Implementation Details

### 1. Thread Safety
All public methods use the `synchronized` keyword to ensure thread safety:
```java
public static synchronized Logger getInstance() { ... }
public synchronized void write(String message) { ... }
```

### 2. Lazy Initialization
The Logger instance is only created when `getInstance()` is first called:
```java
if (instance == null) {
    instance = new Logger();
}
```

### 3. Resource Management
- Uses `BufferedWriter` for improved write efficiency
- `flush()` ensures messages are immediately written to disk
- `close()` method properly releases file resources

### 4. Exception Handling
All file I/O operations include exception handling:
```java
try {
    writer.write(message);
    writer.newLine();
    writer.flush();
} catch (IOException e) {
    System.err.println("Error writing to log file: " + e.getMessage());
}
```

### 5. Automatic Directory Creation
The Logger automatically creates the `logs` directory if it doesn't exist:
```java
private void createLogDirectory() {
    File directory = new File(LOG_DIRECTORY);
    if (!directory.exists()) {
        directory.mkdirs();
    }
}
```

## Comparison with Example Code

This implementation follows the patterns from the provided examples:

| Feature | Timer Example | ConnectionPool Example | Logger Implementation |
|---------|--------------|----------------------|---------------------|
| Private Constructor | ✓ | ✓ | ✓ |
| Static getInstance() | ✓ | ✓ | ✓ |
| Synchronized Methods | ✓ | ✓ | ✓ |
| Lazy Loading | ✓ | ✓ | ✓ |
| Resource Management | - | ✓ (connection pool) | ✓ (file) |

## Real-World Application Scenarios

In real applications, the Logger would be used in multiple places:
```java
// Using the same Logger in different classes
public class UserService {
    public void createUser(String name) {
        Logger.getInstance().write("Creating user: " + name);
        // ... business logic
    }
}

public class OrderService {
    public void processOrder(int orderId) {
        Logger.getInstance().write("Processing order: " + orderId);
        // ... business logic
    }
}
```

All logs are written to the same file, making tracking and debugging easier.

## Important Notes

1. **Always call close()**: Make sure to call `logger.close()` before the program ends to release resources
2. **File Location**: Log files are created in `src/main/java/singleton/logger/logs/` directory. The logs folder is created automatically on first run in the same package as the Logger class
3. **Append Mode**: Uses `FileWriter(fileName, true)` to append to files without overwriting existing content
4. **Thread Safety**: All methods are thread-safe and can be used in multi-threaded environments
5. **Directory Permissions**: Ensure the program has permission to create the `logs/` folder in the logger package directory
6. **.gitignore**: The `.gitignore` file is placed in the `singleton/logger/` package directory to exclude log files from version control

## Possible Extensions

- Add log levels (INFO, WARNING, ERROR)
- Add timestamps
- Implement log file rotation (by size or time)
- Support multiple output targets simultaneously (file, console, database)
- Add filtering and formatting options

## Author

Created as part of Design Patterns Assignment 5

## References

- [Refactoring Guru - Singleton Pattern](https://refactoring.guru/design-patterns/singleton)
- [SourceMaking - Singleton Pattern](https://sourcemaking.com/design_patterns/singleton)
