public class FeedbackSystem {
    public static void main(String[] args) {
        // create the handler chain
        Handler compensationHandler = new CompensationHandler();
        Handler contactHandler = new ContactRequestHandler();
        Handler suggestionHandler = new DevelopmentSuggestionHandler();
        Handler feedbackHandler = new GeneralFeedbackHandler();

        // link the handlers
        compensationHandler.setNextHandler(contactHandler);
        contactHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(feedbackHandler);

        // the first handler in the chain
        Handler primaryHandler = compensationHandler;

        System.out.println("========== Customer Feedback Processing System ==========\n");

        // test message 1: compensation claim
        Message message1 = new Message(
            MessageType.COMPENSATION_CLAIM,
            "My order arrived damaged and I would like a refund of $50.",
            "customer1@email.com"
        );
        System.out.println("Processing Message 1:");
        primaryHandler.handleMessage(message1);
        System.out.println("\n" + "=".repeat(60) + "\n");

        // test message 2: contact request
        Message message2 = new Message(
            MessageType.CONTACT_REQUEST,
            "I have a technical issue with your software. It keeps crashing on startup.",
            "techuser@email.com"
        );
        System.out.println("Processing Message 2:");
        primaryHandler.handleMessage(message2);
        System.out.println("\n" + "=".repeat(60) + "\n");

        // test message 3: development suggestion
        Message message3 = new Message(
            MessageType.DEVELOPMENT_SUGGESTION,
            "It would be great to have a dark mode feature. This is an important improvement for user experience.",
            "designer@email.com"
        );
        System.out.println("Processing Message 3:");
        primaryHandler.handleMessage(message3);
        System.out.println("\n" + "=".repeat(60) + "\n");

        // test message 4: general feedback (positive)
        Message message4 = new Message(
            MessageType.GENERAL_FEEDBACK,
            "I love your product! It's amazing and works great for my needs.",
            "happycustomer@email.com"
        );
        System.out.println("Processing Message 4:");
        primaryHandler.handleMessage(message4);
        System.out.println("\n" + "=".repeat(60) + "\n");

        // test message 5: general feedback (negative)
        Message message5 = new Message(
            MessageType.GENERAL_FEEDBACK,
            "I'm disappointed with the recent update. The performance is terrible now.",
            "frustrated@email.com"
        );
        System.out.println("Processing Message 5:");
        primaryHandler.handleMessage(message5);
        System.out.println("\n" + "=".repeat(60) + "\n");

        // test message 6: contact request for billing
        Message message6 = new Message(
            MessageType.CONTACT_REQUEST,
            "I was charged twice for my subscription. Can someone help with billing?",
            "billing@email.com"
        );
        System.out.println("Processing Message 6:");
        primaryHandler.handleMessage(message6);

        System.out.println("\n========== All messages processed ==========");
    }
}

