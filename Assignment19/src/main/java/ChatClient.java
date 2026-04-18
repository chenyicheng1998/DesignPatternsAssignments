public class ChatClient {
    private String username;
    private ChatMediator mediator;
    private ChatClientGUI gui;

    public ChatClient(String username, ChatMediator mediator) {
        this.username = username;
        this.mediator = mediator;
        mediator.registerClient(this);
    }

    public String getUsername() {
        return username;
    }

    public void setGUI(ChatClientGUI gui) {
        this.gui = gui;
    }

    public void sendMessage(String message, String to) {
        String displayMessage = "You to " + to + ": " + message;
        gui.displayMessage(displayMessage);
        mediator.sendMessage(message, username, to);
    }

    public void receiveMessage(String message, String from) {
        String displayMessage = from + " to You: " + message;
        gui.displayMessage(displayMessage);
    }
}

