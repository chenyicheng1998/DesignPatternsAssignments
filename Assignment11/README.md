# Assignment 11: Improved History Functionality using Memento Pattern

## Overview

This assignment implements an enhanced Memento pattern application with undo/redo functionality and a history window. The application provides a graphical user interface with three colored rectangles and a checkbox, allowing users to change colors and toggle the checkbox state. All state changes can be undone and redone, and users can view the complete history of state changes.

## Features Implemented

### 1. Undo Functionality (Ctrl+Z)
- Users can press `Ctrl+Z` to undo the last action
- The current state is saved to the redo history before undoing
- Previous state is restored from the undo history

### 2. Redo Functionality (Ctrl+Y)
- Users can press `Ctrl+Y` to redo the last undone action
- The current state is saved to the undo history before redoing
- The next state is restored from the redo history
- The redo history is automatically cleared when a new change is made to the model

### 3. History Window
- Users can click the "Show History" button to open a separate history window
- The history window displays a timestamped list of all saved states
- Users can click on any state in the list to restore the model to that exact state
- The history window updates dynamically as users make changes

## Class Structure

### Core Classes

- **`IMemento`**: Interface that defines metadata methods for mementos
  - `getTimestamp()`: Returns when the state was saved
  - `getDescription()`: Returns a human-readable description of the state

- **`Memento`**: Concrete implementation of IMemento
  - Stores the complete state (options array and checkbox status)
  - Automatically records the timestamp when created
  - Provides methods to retrieve the saved state

- **`Model`**: The originator class that holds the application state
  - Maintains the options array (colors) and checkbox state
  - Creates mementos to save state
  - Restores state from mementos

- **`Controller`**: The caretaker class that manages undo/redo history
  - Maintains separate lists for undo and redo history
  - Implements undo and redo logic
  - Clears redo history when new changes are made
  - Provides methods to restore specific states from history

- **`Gui`**: JavaFX application that provides the user interface
  - Displays three colored rectangles and a checkbox
  - Provides buttons for undo, redo, and history window
  - Handles keyboard shortcuts (Ctrl+Z for undo, Ctrl+Y for redo)
  - Updates the display when state changes

- **`ColorBox`**: Represents a clickable colored rectangle
  - Cycles through three colors: red, blue, and yellow
  - Notifies the controller when clicked

- **`HistoryWindow`**: A separate JavaFX window for viewing history
  - Displays timestamped list of saved states
  - Allows users to restore states by clicking on them
  - Updates dynamically as history changes

- **`Main`**: Entry point for the application

## Design Patterns Used

1. **Memento Pattern**: 
   - Used to capture and restore the complete application state
   - IMemento interface hides implementation details from the caretaker
   
2. **Model-View-Controller (MVC)**:
   - Model: Stores and manages state
   - View: Gui and HistoryWindow display the state
   - Controller: Manages interaction between model and views

## How to Run

1. Navigate to the Assignment11 directory
2. Compile and run using Maven:
   ```bash
   mvn clean javafx:run
   ```
   Or build and run directly:
   ```bash
   mvn clean compile
   java -p target/classes javafx.controls,javafx.fxml -m assignment11/memento.guistate.Main
   ```

## User Interactions

1. **Changing Colors**: Click on any colored rectangle to cycle through colors (red → blue → yellow → red)
2. **Toggling Checkbox**: Click the checkbox to change its state
3. **Undo**: Press `Ctrl+Z` or click the "Undo" button to revert to the previous state
4. **Redo**: Press `Ctrl+Y` or click the "Redo" button to restore the next state
5. **View History**: Click "Show History" to open the history window and see all saved states
6. **Restore from History**: Click on any entry in the history window to restore the model to that state

## Notes

- The redo history is cleared whenever a new change is made to the model, following standard undo/redo behavior
- Timestamps are recorded to the second, providing users with clear information about when each state was saved
- The history window remains open and continuously updates as changes are made
- The application does not limit the number of mementos stored, so users should be aware of memory usage for very long sessions

