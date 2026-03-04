public class CompensationHandler extends Handler {

    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.COMPENSATION_CLAIM) {
            System.out.println("CompensationHandler: Processing compensation claim");
            System.out.println("  From: " + message.getSenderEmail());
            System.out.println("  Content: " + message.getContent());

            // simulate reviewing the claim
            System.out.println("  -> Reviewing claim for validity...");
            System.out.println("  -> Checking customer history...");
            System.out.println("  -> Claim has been approved. Compensation will be processed.");
            System.out.println("  -> Email notification sent to " + message.getSenderEmail());
        } else {
            System.out.println("CompensationHandler: Not a compensation claim. Forwarding...");
            super.handleMessage(message);
        }
    }
}

