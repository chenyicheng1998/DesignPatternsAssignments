package memento.guistate;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HistoryWindow {
    private Stage stage;
    private ListView<String> historyListView;
    private Controller controller;

    public HistoryWindow(Controller controller) {
        this.controller = controller;
        initializeWindow();
    }

    private void initializeWindow() {
        stage = new Stage();
        stage.setTitle("History Window");
        stage.setWidth(300);
        stage.setHeight(400);

        historyListView = new ListView<>();
        historyListView.setStyle("-fx-font-size: 12;");

        // When user clicks on an item in the list, restore that state
        historyListView.setOnMouseClicked(event -> {
            int selectedIndex = historyListView.getSelectionModel().getSelectedIndex();
            if (selectedIndex >= 0) {
                IMemento selectedMemento = controller.getUndoHistory().get(selectedIndex);
                controller.restoreToMemento(selectedMemento);
            }
        });

        VBox vBox = new VBox(historyListView);
        vBox.setPadding(new Insets(10));

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }

    public void updateHistory() {
        historyListView.getItems().clear();
        var history = controller.getUndoHistory();
        for (int i = 0; i < history.size(); i++) {
            IMemento memento = history.get(i);
            String description = memento.getDescription();
            historyListView.getItems().add((i + 1) + ". " + description);
        }
    }
}

