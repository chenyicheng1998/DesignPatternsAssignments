# Assignment 4: Weather Station Simulator

## Overview

This project implements a Weather Station Simulator using the **Observer design pattern**. The system consists of a weather station that continuously monitors and updates temperature, and multiple observers that receive notifications when the temperature changes.

## Design Pattern: Observer

The Observer pattern is a behavioral design pattern that defines a one-to-many dependency between objects. When the subject (observable) changes state, all its dependents (observers) are notified and updated automatically.

## Project Structure

```
Assignment4/
└── src/
    └── main/
        └── java/
            └── weather/
                ├── Main.java                    # Main class with demo
                ├── model/
                │   ├── Observable.java         # Abstract observable class
                │   └── WeatherStation.java     # Concrete observable (Subject)
                └── view/
                    ├── Observer.java           # Observer interface
                    └── WeatherObserver.java    # Concrete observer
```

## Class Diagram

```
┌─────────────────────────┐
│      Observable         │
├─────────────────────────┤
│ - observers: List       │
├─────────────────────────┤
│ + addObserver()         │
│ + removeObserver()      │
│ # notifyObservers()     │
└───────────▲─────────────┘
            │
            │ extends
            │
┌───────────┴─────────────┐
│    WeatherStation       │
├─────────────────────────┤
│ - temperature: double   │
│ - random: Random        │
│ - running: boolean      │
├─────────────────────────┤
│ + getTemperature()      │
│ - updateTemperature()   │
│ + run()                 │
│ + stop()                │
└─────────────────────────┘

┌─────────────────────────┐
│      Observer           │
├─────────────────────────┤
│ + update()              │
└───────────▲─────────────┘
            │
            │ implements
            │
┌───────────┴─────────────┐
│   WeatherObserver       │
├─────────────────────────┤
│ - observerName: String  │
│ - weatherStation        │
├─────────────────────────┤
│ + update()              │
│ + getObserverName()     │
└─────────────────────────┘
```

## Classes Description

### 1. Observer (Interface) - `weather.view`
- Defines the `update()` method that all observers must implement
- Called by the observable when its state changes

### 2. Observable (Abstract Class) - `weather.model`
- Maintains a list of observers
- Provides methods to:
  - `addObserver(Observer)` - Register a new observer
  - `removeObserver(Observer)` - Unregister an observer
  - `notifyObservers()` - Notify all registered observers

### 3. WeatherStation (Concrete Observable) - `weather.model`
- Extends `Observable` and implements `Runnable`
- Runs in its own thread
- Features:
  - Initial random temperature between -30°C and 50°C
  - Continuously updates temperature by ±1 degree
  - Random update intervals between 1-5 seconds
  - Enforces min/max temperature bounds
  - Notifies observers after each temperature change

### 4. WeatherObserver (Concrete Observer) - `weather.view`
- Implements the `Observer` interface
- Each observer has a unique name (e.g., "Phone App", "Desktop Widget")
- When notified, queries the weather station for current temperature and displays it

### 5. Main Class - `weather`
- Demonstrates the Observer pattern in action:
  1. Creates a weather station
  2. Creates and registers 3 observers
  3. Starts the weather station thread
  4. Runs for 15 seconds with all observers active
  5. Removes one observer
  6. Continues for another 15 seconds (demonstrating the removed observer no longer receives updates)
  7. Stops the weather station gracefully

## Key Features

✅ **Thread-based Weather Station**: Runs continuously in its own thread  
✅ **Random Temperature Generation**: Initial random temperature on startup  
✅ **Gradual Temperature Changes**: ±1 degree increments/decrements  
✅ **Random Update Intervals**: 1-5 seconds between updates  
✅ **Temperature Bounds**: Min -30°C, Max 50°C  
✅ **Dynamic Observer Management**: Observers can be added/removed at runtime  
✅ **Unique Observer Messages**: Each observer displays its own identification  
✅ **Graceful Shutdown**: Weather station can be stopped cleanly  

## How to Run

### Compile
```bash
cd C:\Users\cheny\IdeaProjects\DesignPatternsAssignments\Assignment4\src\main\java
javac weather\Main.java weather\model\*.java weather\view\*.java
```

### Run
```bash
java weather.Main
```

## Expected Output

```
=== Weather Station Simulator ===

Weather Station initialized with temperature: 15.3°C

All observers registered. Starting weather station...

[Observer 1 - Phone App] Temperature updated: 16.3°C
[Observer 2 - Desktop Widget] Temperature updated: 16.3°C
[Observer 3 - Smart Watch] Temperature updated: 16.3°C
[Observer 1 - Phone App] Temperature updated: 17.3°C
[Observer 2 - Desktop Widget] Temperature updated: 17.3°C
[Observer 3 - Smart Watch] Temperature updated: 17.3°C
...

=== Removing Observer 2 - Desktop Widget ===

[Observer 1 - Phone App] Temperature updated: 18.3°C
[Observer 3 - Smart Watch] Temperature updated: 18.3°C
[Observer 1 - Phone App] Temperature updated: 17.3°C
[Observer 3 - Smart Watch] Temperature updated: 17.3°C
...

=== Stopping Weather Station ===
Weather station stopped

Simulation completed.
```

Notice that after Observer 2 is removed, only Observer 1 and Observer 3 receive updates.

## Design Decisions

1. **Package Organization**: Following the example structure, separated code into:
   - `weather.model` - Contains the Observable and WeatherStation (business logic)
   - `weather.view` - Contains the Observer interface and WeatherObserver (presentation)
   - `weather` - Contains the Main class
2. **Thread Safety**: Used `volatile` keyword for the `running` flag to ensure visibility across threads
3. **Temperature Bounds**: Set realistic min/max values to prevent unrealistic temperatures
4. **Random Intervals**: Makes the simulation more realistic and demonstrates asynchronous notifications
5. **Observer Names**: Each observer has a unique name to clearly demonstrate which observers are active
6. **Graceful Shutdown**: Implemented `stop()` method to cleanly terminate the weather station thread

## Requirements Fulfilled

✅ Weather station runs in its own thread  
✅ Observers can be registered and removed  
✅ Observers are notified on temperature changes  
✅ Each observer displays unique messages with current temperature  
✅ Constructor sets initial random temperature  
✅ Thread runs eternal loop with periodic updates  
✅ Temperature changes by small increments (±1 degree)  
✅ Random time intervals between updates (1-5 seconds)  
✅ Min/Max temperature bounds enforced  
✅ Main method demonstrates full functionality  
✅ Demonstrates observer removal (observer no longer receives notifications)  

## Benefits of Observer Pattern

1. **Loose Coupling**: Weather station doesn't need to know details about observers
2. **Dynamic Relationships**: Observers can be added/removed at runtime
3. **Broadcast Communication**: One change notifies all observers automatically
4. **Reusability**: New observer types can be added without modifying existing code
5. **Separation of Concerns**: Weather station focuses on temperature tracking, observers focus on display

## Additional Resources

- [Refactoring Guru: Observer Pattern](https://refactoring.guru/design-patterns/observer)
- [SourceMaking: Observer Pattern](https://sourcemaking.com/design_patterns/observer)
