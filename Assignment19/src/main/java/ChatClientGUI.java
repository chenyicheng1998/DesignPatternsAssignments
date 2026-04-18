import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ChatClientGUI {
    private ChatClient client;
    private ChatServer server;
    private TextArea messageArea;
    private TextField messageField;
    private ComboBox<String> recipientSelector;
    private Button sendButton;

    public ChatClientGUI(ChatClient client, ChatServer server) {
        this.client = client;
        this.server = server;
        client.setGUI(this);
    }

    public void start(Stage stage) {
        stage.setTitle("Chat Client - " + client.getUsername());

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));

        // Message display area
        messageArea = new TextArea();
        messageArea.setEditable(false);
        messageArea.setPrefHeight(300);
        messageArea.setWrapText(true);

        // Recipient selector
        Label recipientLabel = new Label("Select recipient:");
        recipientSelector = new ComboBox<>();
        updateRecipientList();

        // Message input field
        Label messageLabel = new Label("Your message:");
        messageField = new TextField();
        messageField.setPrefWidth(300);

        // Send button
        sendButton = new Button("Send Message");
        sendButton.setOnAction(e -> sendMessage());

        // Allow sending with Enter key
        messageField.setOnAction(e -> sendMessage());

        root.getChildren().addAll(
            messageArea,
            recipientLabel,
            recipientSelector,
            messageLabel,
            messageField,
            sendButton
        );

        Scene scene = new Scene(root, 400, 450);
        stage.setScene(scene);
        stage.show();

        displayMessage("Welcome to the chat, " + client.getUsername() + "!");
    }

    private void updateRecipientList() {
        List<String> allUsers = server.getClientUsernames();
        recipientSelector.getItems().clear();

        for (String username : allUsers) {
            if (!username.equals(client.getUsername())) {
                recipientSelector.getItems().add(username);
            }
        }

        if (!recipientSelector.getItems().isEmpty()) {
            recipientSelector.getSelectionModel().selectFirst();
        }
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        String recipient = recipientSelector.getValue();

        if (message.isEmpty()) {
            displayMessage("Error: Message cannot be empty");
            return;
        }

        if (recipient == null) {
            displayMessage("Error: Please select a recipient");
            return;
        }

        client.sendMessage(message, recipient);
        messageField.clear();
    }

    public void displayMessage(String message) {
        messageArea.appendText(message + "\n");
    }
}

