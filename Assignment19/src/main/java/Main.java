import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create the mediator (chat server)
        ChatServer server = new ChatServer();

        // Create three chat clients
        ChatClient client1 = new ChatClient("Alice", server);
        ChatClient client2 = new ChatClient("Bob", server);
        ChatClient client3 = new ChatClient("Charlie", server);

        // Create GUI for each client
        ChatClientGUI gui1 = new ChatClientGUI(client1, server);
        ChatClientGUI gui2 = new ChatClientGUI(client2, server);
        ChatClientGUI gui3 = new ChatClientGUI(client3, server);

        // Create stages for each client window
        Stage stage1 = new Stage();
        Stage stage2 = new Stage();
        Stage stage3 = new Stage();

        // Position windows
        stage1.setX(100);
        stage1.setY(100);

        stage2.setX(550);
        stage2.setY(100);

        stage3.setX(1000);
        stage3.setY(100);

        // Start each GUI
        gui1.start(stage1);
        gui2.start(stage2);
        gui3.start(stage3);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

