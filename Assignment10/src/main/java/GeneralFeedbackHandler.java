public class GeneralFeedbackHandler extends Handler {

    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.GENERAL_FEEDBACK) {
            System.out.println("GeneralFeedbackHandler: Processing general feedback");
            System.out.println("  From: " + message.getSenderEmail());
            System.out.println("  Content: " + message.getContent());

            // analyze sentiment and respond
            String sentiment = analyzeSentiment(message.getContent());
            System.out.println("  -> Sentiment analysis: " + sentiment);
            System.out.println("  -> Feedback recorded in customer database");

            if (sentiment.equals("POSITIVE")) {
                System.out.println("  -> Response: 'Thank you for your positive feedback! We're glad you're satisfied.'");
            } else if (sentiment.equals("NEGATIVE")) {
                System.out.println("  -> Response: 'We apologize for your experience. A manager will contact you shortly.'");
            } else {
                System.out.println("  -> Response: 'Thank you for your feedback. We appreciate your input.'");
            }
        } else {
            System.out.println("GeneralFeedbackHandler: Not general feedback. Forwarding...");
            super.handleMessage(message);
        }
    }

    private String analyzeSentiment(String content) {
        String lowerContent = content.toLowerCase();
        if (lowerContent.contains("great") || lowerContent.contains("excellent") ||
            lowerContent.contains("love") || lowerContent.contains("amazing")) {
            return "POSITIVE";
        } else if (lowerContent.contains("bad") || lowerContent.contains("terrible") ||
                   lowerContent.contains("disappointed") || lowerContent.contains("poor")) {
            return "NEGATIVE";
        } else {
            return "NEUTRAL";
        }
    }
}

