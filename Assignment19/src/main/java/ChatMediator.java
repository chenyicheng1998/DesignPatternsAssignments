public interface ChatMediator {
    void registerClient(ChatClient client);
    void sendMessage(String message, String from, String to);
}

