# Assignment 19: Chat App

## Overview

This is a real-time chat application built with JavaFX that demonstrates the **Mediator design pattern**. The application allows multiple users to communicate with each other through a centralized mediator (chat server) without direct client-to-client communication.

## Design Pattern: Mediator

The Mediator pattern is used to reduce coupling between components that communicate with each other. Instead of components referring to each other explicitly, they communicate through a mediator object.

### Key Benefits
- **Reduced coupling**: Clients don't know about each other
- **Centralized control**: All communication goes through the mediator
- **Easy to extend**: Adding new clients doesn't require changing existing code
- **Simplified communication**: Complex many-to-many relationships become one-to-many

## Architecture

### Components

#### 1. `ChatMediator` Interface
Defines the contract for the mediator:
- `registerClient(ChatClient)` - Register a new client
- `sendMessage(String, String, String)` - Route messages between clients

#### 2. `ChatServer` Class (Concrete Mediator)
Implements the ChatMediator interface and manages all communication:
- Maintains a list of all registered clients
- Routes messages from sender to recipient
- Provides list of available users

#### 3. `ChatClient` Class (Colleague)
Represents the controller for a chat client:
- Has a unique username
- Communicates only with the mediator, not other clients
- Sends messages through the mediator
- Receives messages from the mediator
- Updates its GUI when messages arrive

#### 4. `ChatClientGUI` Class (View)
JavaFX-based user interface for each client:
- Displays chat history in a TextArea
- ComboBox to select message recipient
- TextField for message input
- Send button to transmit messages

#### 5. `Main` Class
Application entry point that:
- Creates the ChatServer (mediator)
- Creates three ChatClients: Alice, Bob, and Charlie
- Launches three separate windows, one for each client

## Features

- **Multiple simultaneous chat windows**: Three clients run in separate windows
- **Private messaging**: Users select a recipient from a dropdown
- **Real-time communication**: Messages appear instantly in both sender and recipient windows
- **Clear message format**: Shows who sent/received each message
- **Simple UI**: Clean interface with all necessary controls

## How to Run

```bash
javac *.java
java Main
```

Or use Maven:
```bash
mvn clean javafx:run
```

## Usage

1. Launch the application - three windows will appear (Alice, Bob, Charlie)
2. In any window, select a recipient from the dropdown
3. Type your message in the text field
4. Click "Send Message" or press Enter
5. The message appears in both sender's and recipient's windows

## Design Pattern Implementation

### Mediator Pattern Structure

```
ChatClient (Alice) ─┐
                    │
ChatClient (Bob) ───┼──> ChatServer (Mediator)
                    │
ChatClient (Charlie)┘
```

### Communication Flow

1. **User sends message**:
   - User types message in ChatClientGUI
   - GUI calls `client.sendMessage(message, recipient)`
   - Client calls `mediator.sendMessage(message, from, to)`

2. **Mediator routes message**:
   - ChatServer receives the message
   - Server finds the recipient client
   - Server calls `recipient.receiveMessage(message, from)`

3. **Recipient receives message**:
   - Client's `receiveMessage()` is called
   - Client updates its GUI
   - Message appears in recipient's TextArea

### Key Design Decisions

- **Separation of concerns**: ChatClient (controller) is separate from ChatClientGUI (view)
- **No direct communication**: Clients never call each other's methods directly
- **Mediator knows all**: Only the ChatServer knows about all clients
- **Simple threading**: No need for threads since all clients run in the same JVM

## Extending the Application

To add more clients:
```java
ChatClient client4 = new ChatClient("David", server);
ChatClientGUI gui4 = new ChatClientGUI(client4, server);
Stage stage4 = new Stage();
gui4.start(stage4);
```

## Pattern Comparison

Unlike MVC pattern which focuses on separating model-view-controller concerns, the Mediator pattern focuses on **decoupling communication** between components. In this application:
- **No MVC**: We deliberately avoid MVC to demonstrate pure Mediator pattern
- **Focus**: Communication management, not data-view separation
- **Benefit**: Clients are completely independent and don't know each other exist

