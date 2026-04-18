import java.util.ArrayList;
import java.util.List;

public class ChatServer implements ChatMediator {
    private List<ChatClient> clients;

    public ChatServer() {
        this.clients = new ArrayList<>();
    }

    @Override
    public void registerClient(ChatClient client) {
        clients.add(client);
        System.out.println("Client registered: " + client.getUsername());
    }

    @Override
    public void sendMessage(String message, String from, String to) {
        System.out.println("Message from " + from + " to " + to + ": " + message);

        for (ChatClient client : clients) {
            if (client.getUsername().equals(to)) {
                client.receiveMessage(message, from);
                break;
            }
        }
    }

    public List<String> getClientUsernames() {
        List<String> usernames = new ArrayList<>();
        for (ChatClient client : clients) {
            usernames.add(client.getUsername());
        }
        return usernames;
    }
}

