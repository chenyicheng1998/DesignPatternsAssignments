# Assignment 10: Customer Feedback Handler

## Overview
This project implements a customer feedback processing system using the **Chain of Responsibility design pattern**. The system automatically routes different types of customer feedback messages to appropriate handlers.

## Design Pattern: Chain of Responsibility
The Chain of Responsibility pattern allows a request to pass through a chain of handlers. Each handler decides either to process the request or pass it to the next handler in the chain.

### Components:

1. **Message Class**: Represents a customer feedback message with:
   - Message type (enum)
   - Message content
   - Sender email

2. **MessageType Enum**: Defines four types of feedback:
   - `COMPENSATION_CLAIM` - Customer requests compensation or refund
   - `CONTACT_REQUEST` - Customer wants to be contacted
   - `DEVELOPMENT_SUGGESTION` - Customer suggests new features or improvements
   - `GENERAL_FEEDBACK` - General comments or reviews

3. **Handler (Abstract Class)**: Base class for all handlers that:
   - Maintains reference to the next handler in the chain
   - Provides default behavior to pass messages along the chain

4. **Concrete Handlers**:
   - **CompensationHandler**: Reviews and approves/rejects compensation claims
   - **ContactRequestHandler**: Routes contact requests to appropriate departments (Technical Support, Billing, Sales, Customer Service)
   - **DevelopmentSuggestionHandler**: Logs suggestions and assigns priority levels (HIGH, MEDIUM, LOW)
   - **GeneralFeedbackHandler**: Analyzes sentiment (POSITIVE, NEGATIVE, NEUTRAL) and generates appropriate responses

## Project Structure
```
src/main/java/
├── MessageType.java                    # Enum defining message types
├── Message.java                        # Message data class
├── Handler.java                        # Abstract handler base class
├── CompensationHandler.java            # Handles compensation claims
├── ContactRequestHandler.java          # Routes contact requests
├── DevelopmentSuggestionHandler.java   # Processes feature suggestions
├── GeneralFeedbackHandler.java         # Handles general feedback
└── FeedbackSystem.java                 # Main program demonstrating the system
```

## How It Works

1. **Chain Setup**: Handlers are linked together in a chain:
   ```
   CompensationHandler → ContactRequestHandler → 
   DevelopmentSuggestionHandler → GeneralFeedbackHandler
   ```

2. **Message Processing**: 
   - Each message enters the chain at the first handler
   - Each handler checks if it can process the message type
   - If yes, it processes and stops
   - If no, it forwards to the next handler

3. **Handler-Specific Processing**:
   - **Compensation**: Reviews claims, checks customer history, approves/rejects
   - **Contact**: Determines appropriate department based on keywords in content
   - **Development**: Assesses priority based on keywords (urgent, important, etc.)
   - **General**: Analyzes sentiment using keyword matching

## How to Run
```bash
cd src/main/java
javac *.java
java FeedbackSystem
```

## Example Output

The program demonstrates handling 6 different messages:

1. **Compensation Claim**: Customer requests refund for damaged order
   - ✓ Reviewed and approved
   
2. **Technical Contact Request**: Customer has software crash issue
   - ✓ Forwarded to Technical Support department

3. **Development Suggestion**: Customer suggests dark mode feature
   - ✓ Logged with HIGH priority

4. **Positive General Feedback**: Customer loves the product
   - ✓ Sentiment: POSITIVE, positive response sent

5. **Negative General Feedback**: Customer disappointed with update
   - ✓ Sentiment: NEGATIVE, manager follow-up initiated

6. **Billing Contact Request**: Customer has billing issue
   - ✓ Forwarded to Billing department

## Key Features

- **Automatic Routing**: Messages automatically go to the correct handler
- **Smart Processing**: Each handler uses logic to process messages appropriately
- **Department Detection**: Contact requests routed based on content keywords
- **Priority Assessment**: Development suggestions prioritized automatically
- **Sentiment Analysis**: Feedback analyzed for emotional tone
- **Flexible Chain**: Easy to add new handler types or reorder the chain

## Design Benefits

1. **Decoupling**: Senders don't need to know which handler will process their message
2. **Flexibility**: Easy to add, remove, or reorder handlers
3. **Single Responsibility**: Each handler focuses on one type of message
4. **Open/Closed Principle**: Can extend with new handlers without modifying existing code

## Pattern Demonstration

The implementation clearly shows the Chain of Responsibility pattern where:
- Each handler independently decides if it can process a message
- Handlers are loosely coupled through the abstract Handler class
- The chain can be easily reconfigured at runtime
- Messages flow through the chain until processed

