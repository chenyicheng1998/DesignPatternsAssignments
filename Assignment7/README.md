# Assignment 7: Game Character Development System (State Pattern)

## Overview

This assignment demonstrates the **State Design Pattern** by implementing a console-based game character development system. The character progresses through different levels (states) by performing various actions like training, meditating, and fighting.

## Project Structure

```
Assignment7/
├── README.md
├── pom.xml
└── src/main/java/
    ├── GameCharacter.java      # Context class (manages character state)
    ├── State.java              # Abstract state class
    ├── NoviceState.java        # Concrete state (Level 1)
    ├── IntermediateState.java  # Concrete state (Level 2)
    ├── ExpertState.java        # Concrete state (Level 3)
    ├── MasterState.java        # Concrete state (Level 4 - Final)
    └── Main.java               # Entry point
```

## Implementation

### Character Attributes

- **Name**: Player-chosen character name
- **Level**: Current level (1-4)
- **Experience Points (XP)**: Used to progress to next level
- **Health Points (HP)**: Affected by actions, starts at 100

### States (Levels)

#### 1. Novice Level (Level 1)
- **Available Actions**: Train only
- **Train**: Increases XP by 15-25 points
- **Requirement to Advance**: 50 XP

#### 2. Intermediate Level (Level 2)
- **Available Actions**: Train, Meditate
- **Train**: Increases XP by 12-20 points
- **Meditate**: Restores 15-25 HP and gains 3-7 XP
- **Requirement to Advance**: 120 XP

#### 3. Expert Level (Level 3)
- **Available Actions**: Train, Meditate, Fight
- **Train**: Increases XP by 10-20 points
- **Meditate**: Restores 20-30 HP and gains 5-10 XP
- **Fight**: 
  - Requires minimum 20 HP
  - 70% chance of victory
  - Victory: +25-40 XP, -10-20 HP
  - Defeat: +10-15 XP, -20-30 HP
- **Requirement to Advance**: 200 XP

#### 4. Master Level (Level 4)
- **Final State**: Game ends when reached
- Character becomes a true master!

## State Transitions

```
NoviceState (50 XP required)
      ↓
IntermediateState (120 XP required)
      ↓
ExpertState (200 XP required)
      ↓
MasterState (GAME ENDS)
```

## Usage

### Compile
```bash
mvn clean compile
```

### Run
```bash
java -cp target/classes Main
```

### Sample Gameplay

```
Enter your character's name: Hero

┌─────────────────────────────────────┐
│      CHARACTER STATUS               │
├─────────────────────────────────────┤
│ Name:       Hero                    │
│ Level:      Novice (Level 1)        │
│ Experience: 0 XP                    │
│ Health:     100 HP                  │
└─────────────────────────────────────┘

Available Actions:
  1. Train

Choose an action (1-1): 1

⚔️  Training...
You practice basic combat moves and study techniques.
✨ Gained 18 XP! Total: 18 XP
```

## State Pattern Implementation

### Key Components

1. **Context (`GameCharacter`)**: 
   - Maintains reference to current state
   - Delegates action handling to current state
   - Displays character status

2. **Abstract State (`State`)**:
   - Defines interface for handling actions
   - Provides common level-up logic

3. **Concrete States**:
   - `NoviceState`: Basic training only
   - `IntermediateState`: Training + Meditation
   - `ExpertState`: Training + Meditation + Fighting
   - `MasterState`: Final state (game ends)

### State Transitions

States transition automatically when the character gains enough XP. Each state creates the next state dynamically when advancement conditions are met.

## Design Pattern Benefits

- ✅ **Encapsulation**: Each state encapsulates its own behavior
- ✅ **Open/Closed Principle**: New levels can be added without modifying existing code
- ✅ **Single Responsibility**: Each state handles only its own actions
- ✅ **Clear State Transitions**: Explicit progression path through levels

## Key Features

- 🎮 **Interactive Console Gameplay**: User-driven action selection
- 📊 **Visual Status Display**: Clear character information
- 🎲 **Random Elements**: Variable XP/HP gains for replayability
- ⚔️ **Risk/Reward Combat**: Fighting has uncertain outcomes
- 💚 **Health Management**: Strategic decision-making required
- 🎉 **Progressive Difficulty**: XP requirements increase per level

## UML State Diagram

```
       GameCharacter
            │
            │ has-a
            ▼
          State (abstract)
            △
            │
    ┌───────┼───────┬────────┐
    │       │       │        │
 Novice  Intermediate Expert Master
  (50)     (120)     (200)  (Final)
```

## Additional Features

1. **Health System**: Characters must manage HP strategically
2. **Combat Mechanics**: Risk/reward system with success probability
3. **Multiple Paths**: Different action combinations lead to victory
4. **Visual Feedback**: Emoji and box-drawing for better UX
5. **Input Validation**: Handles invalid user input gracefully

---

**Assignment Requirements**: ✅ All satisfied  
**Status**: Complete and tested  
**Pattern**: State Design Pattern successfully implemented
