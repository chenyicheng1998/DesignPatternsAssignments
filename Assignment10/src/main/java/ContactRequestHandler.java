public class ContactRequestHandler extends Handler {

    @Override
    public void handleMessage(Message message) {
        if (message.getType() == MessageType.CONTACT_REQUEST) {
            System.out.println("ContactRequestHandler: Processing contact request");
            System.out.println("  From: " + message.getSenderEmail());
            System.out.println("  Content: " + message.getContent());

            // determine which department to forward to
            String department = determineDepartment(message.getContent());
            System.out.println("  -> Request forwarded to " + department + " department");
            System.out.println("  -> Automated reply sent: 'Thank you for contacting us. A representative will reach out within 24 hours.'");
        } else {
            System.out.println("ContactRequestHandler: Not a contact request. Forwarding...");
            super.handleMessage(message);
        }
    }

    private String determineDepartment(String content) {
        String lowerContent = content.toLowerCase();
        if (lowerContent.contains("technical") || lowerContent.contains("bug")) {
            return "Technical Support";
        } else if (lowerContent.contains("billing") || lowerContent.contains("payment")) {
            return "Billing";
        } else if (lowerContent.contains("sales") || lowerContent.contains("purchase")) {
            return "Sales";
        } else {
            return "Customer Service";
        }
    }
}

