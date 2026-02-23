# Assignment 8: Template Method Pattern - Number Guessing Game

## Overview

This assignment implements a simple console-based Number Guessing Game using the Template Method design pattern. The game framework is defined in the abstract `Game` class, which provides a template method that controls the flow of the game.

## Pattern Implementation

### Template Method Pattern

The **Game** class defines the template method `play()` which establishes the game flow:
1. Initialize the game with a number of players
2. Loop through players taking turns until the game ends
3. Display the winner

The concrete game implementation (`NumberGuessingGame`) provides specific implementations for:
- `initializeGame()` - Set up players, rounds, and game parameters
- `endOfGame()` - Check if all rounds have been completed
- `playSingleTurn()` - Handle a single player's turn
- `displayWinner()` - Show final scores and announce the winner

## Game Rules

1. Players take turns guessing a number between 1 and 10
2. Each round, a new random target number is generated
3. If a player guesses correctly, they earn a point
4. After all rounds are completed, the player with the most points wins

## Classes

### Game (Abstract)
The framework class that defines the template method and abstract methods for subclasses to implement.

### NumberGuessingGame
Concrete implementation of the Game class that implements a number guessing game.

### Player
Helper class to store player information (name and score).

### Main
Entry point that creates and starts the game.

## How to Run

Compile and run the `Main` class:

```bash
javac Main.java
java Main
```

The game will prompt you to:
1. Enter names for each player
2. Choose how many rounds to play
3. Take turns guessing numbers

## Example Output

```
=== Number Guessing Game ===
Welcome! Each round, guess a number between 1 and 10.

Enter name for Player 1: Alice
Enter name for Player 2: Bob

How many rounds to play? 3

Let's start!

--- Round 1 ---
Alice, guess a number (1-10): 5
Correct! Alice gets a point!

Bob, guess a number (1-10): 3
Wrong! The number was 7

--- Round 2 ---
...

=== Game Over ===
Final Scores:
Alice: 2 points
Bob: 1 points

Winner: Alice with 2 points!
```

## Design Benefits

- The `Game` class provides a stable framework that doesn't need modification
- New game types can be easily added by extending the `Game` class
- The template method ensures consistent game flow across all implementations
- Game-specific logic is encapsulated in the concrete subclass

