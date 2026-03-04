public class DevelopmentSuggestionHandler extends Handler {

    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.DEVELOPMENT_SUGGESTION) {
            System.out.println("DevelopmentSuggestionHandler: Processing development suggestion");
            System.out.println("  From: " + message.getSenderEmail());
            System.out.println("  Content: " + message.getContent());

            // log and prioritize the suggestion
            String priority = assessPriority(message.getContent());
            System.out.println("  -> Suggestion logged in product backlog");
            System.out.println("  -> Priority level: " + priority);
            System.out.println("  -> Development team will review this suggestion");
            System.out.println("  -> Thank you email sent to " + message.getSenderEmail());
        } else {
            System.out.println("DevelopmentSuggestionHandler: Not a development suggestion. Forwarding...");
            super.handleMessage(message);
        }
    }

    private String assessPriority(String content) {
        String lowerContent = content.toLowerCase();
        if (lowerContent.contains("urgent") || lowerContent.contains("critical") || lowerContent.contains("important")) {
            return "HIGH";
        } else if (lowerContent.contains("improvement") || lowerContent.contains("enhance")) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }
}

