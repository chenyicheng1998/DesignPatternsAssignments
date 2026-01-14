# Assignment 1: Factory Method Pattern - RPG Map Generator

## Overview

This project demonstrates the **Factory Method Design Pattern** through an RPG map generator application. The application can generate two types of maps: City Maps and Wilderness Maps, each containing different types of tiles.

## Design Pattern Implementation

- **Abstract Product**: `Tile` - Base class for all tile types
- **Concrete Products**: `SwampTile`, `WaterTile`, `RoadTile`, `ForestTile`, `BuildingTile`
- **Abstract Creator**: `Map` - Base class that defines the factory method
- **Concrete Creators**: `CityMap`, `WildernessMap` - Implement the factory method to create specific tile types
- **Client**: `Game` - Uses the factory method to generate and display maps

## Project Structure

```
Assignment1/
├── src/
│   └── main/
│       └── java/
│           ├── game/
│           │   └── Game.java          (Client - Main entry point)
│           ├── maps/
│           │   ├── Map.java           (Abstract Creator)
│           │   ├── CityMap.java       (Concrete Creator)
│           │   └── WildernessMap.java (Concrete Creator)
│           └── tiles/
│               ├── Tile.java          (Abstract Product)
│               ├── SwampTile.java     (Concrete Product)
│               ├── WaterTile.java     (Concrete Product)
│               ├── RoadTile.java      (Concrete Product)
│               ├── ForestTile.java    (Concrete Product)
│               └── BuildingTile.java  (Concrete Product)
├── pom.xml
└── README.md
```

## Prerequisites

- Java JDK 17 or higher
- Maven (optional, for Maven-based execution)

## How to Run

### Method 1: Using Maven (Recommended)

#### Compile the project:
```bash
cd Assignment1
mvn clean compile
```

#### Run the application:

**For PowerShell (Windows):**
```powershell
mvn exec:java
```

**For Bash/Linux/Mac:**
```bash
mvn exec:java -Dexec.mainClass="game.Game"
```

#### Or compile and run in one command:

**For PowerShell (Windows):**
```powershell
mvn clean compile exec:java
```

**For Bash/Linux/Mac:**
```bash
mvn clean compile exec:java -Dexec.mainClass="game.Game"
```

**Note**: The mainClass is already configured in `pom.xml`, so you don't need to specify it on Windows PowerShell.

### Method 2: Using javac and java (Manual Compilation)

#### From the Assignment1 directory:

**For PowerShell (Windows):**
```powershell
# Create output directory
New-Item -ItemType Directory -Force -Path bin

# Compile all Java files
javac -d bin src/main/java/tiles/*.java src/main/java/maps/*.java src/main/java/game/*.java

# Run the Game class
java -cp bin game.Game
```

**For Bash/Linux/Mac:**
```bash
# Create output directory
mkdir -p bin

# Compile all Java files
javac -d bin src/main/java/tiles/*.java src/main/java/maps/*.java src/main/java/game/*.java

# Run the Game class
java -cp bin game.Game
```

### Method 3: Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Navigate to `src/main/java/game/Game.java`
3. Right-click on the `Game` class or the `main` method
4. Select "Run 'Game.main()'"

## How to Use

When you run the application, it will automatically generate and display a 10x10 City Map with random tiles.

To generate a different map type, modify the parameter in `Game.java`:
- `createMap(1)` for City Map (contains Roads, Forests, Buildings)
- `createMap(2)` for Wilderness Map (contains Swamps, Water, Forests)

### Map Legend

- **R** = Road (City maps only)
- **F** = Forest (Both map types)
- **B** = Building (City maps only)
- **S** = Swamp (Wilderness maps only)
- **W** = Water (Wilderness maps only)

## Example Output

```
R F B R F B R B F R 
B R F R B F R F B R 
F B R F R B F R B F 
R F B R F R B F R B 
B R F B R F R B F R 
F R B F R B F R B F 
R B F R B F R F B R 
B F R B F R B R F B 
F R B F R B F R B F 
R B F R B F R B F R 
```

## Key Design Pattern Benefits

1. **Extensibility**: New map types can be added by creating new subclasses of `Map` without modifying existing code
2. **Loose Coupling**: The `Map` class doesn't need to know about concrete tile types
3. **Single Responsibility**: Each class has one clear responsibility
4. **Open/Closed Principle**: Open for extension (new map types), closed for modification (existing code)

## Author

Design Patterns Assignment - Factory Method Pattern

## Date

January 2026

