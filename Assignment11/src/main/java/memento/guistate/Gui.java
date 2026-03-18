package memento.guistate;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {

    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private HistoryWindow historyWindow;

    public void start(Stage stage) {

        controller = new Controller(this);
        historyWindow = new HistoryWindow(controller);

        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);

        // Create buttons for undo, redo, and history
        Button undoButton = new Button("Undo (Ctrl+Z)");
        undoButton.setOnAction(event -> controller.undo());

        Button redoButton = new Button("Redo (Ctrl+Y)");
        redoButton.setOnAction(event -> controller.redo());

        Button historyButton = new Button("Show History");
        historyButton.setOnAction(event -> historyWindow.show());

        HBox buttonBox = new HBox(undoButton, redoButton, historyButton);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(insets);

        Label label = new Label("Press Ctrl-Z to undo, Ctrl-Y to redo. Click 'Show History' to view the history window.");
        label.setPadding(insets);
        label.setWrapText(true);

        // Create a VBox that contains everything
        VBox vBox = new VBox(hBox, checkBox, buttonBox, label);

        // Handle CheckBox action
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
            updateHistoryDisplay();
        });

        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                System.out.println("Undo key combination pressed");
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Memento Pattern with Undo/Redo and History");
        stage.setWidth(600);
        stage.setHeight(400);
        stage.show();
    }

    public void updateGui() {
        // called after restoring state from a Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    public void updateHistoryDisplay() {
        historyWindow.updateHistory();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

