package command.pixelart;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * JavaFX application for the Pixel Art Editor.
 *
 * Acts as the Invoker in the Command pattern: it receives user input
 * (keyboard / button), picks the right Command object, and calls execute().
 * The commands then act on the PixelGrid (the Receiver).
 *
 * Controls:
 *   Arrow keys  – move the cursor
 *   Space       – toggle pixel on/off at cursor position
 *   "Create Code" button – print Java array code to the console
 */
public class PixelArtEditor extends Application {

    private static final int CELL_SIZE   = 50;  // pixels per grid cell
    private static final int BORDER      = 3;   // cursor border thickness

    private final PixelGrid grid = new PixelGrid();

    // The rectangle nodes in the grid pane (row, col)
    private final Rectangle[][] cells = new Rectangle[8][8];

    // Pre-created command objects (stateless, reusable)
    private Command moveUp;
    private Command moveDown;
    private Command moveLeft;
    private Command moveRight;
    private Command togglePixel;
    private Command generateCode;

    @Override
    public void start(Stage stage) {
        // --- wire up commands to the receiver ---
        moveUp      = new MoveCursorUpCommand(grid);
        moveDown    = new MoveCursorDownCommand(grid);
        moveLeft    = new MoveCursorLeftCommand(grid);
        moveRight   = new MoveCursorRightCommand(grid);
        togglePixel = new TogglePixelCommand(grid);
        generateCode = new GenerateCodeCommand(grid);

        // --- build the grid pane ---
        GridPane gridPane = new GridPane();
        gridPane.setHgap(2);
        gridPane.setVgap(2);
        gridPane.setPadding(new Insets(10));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: #333333;");

        for (int r = 0; r < grid.getSize(); r++) {
            for (int c = 0; c < grid.getSize(); c++) {
                Rectangle rect = new Rectangle(CELL_SIZE, CELL_SIZE);
                rect.setFill(Color.DARKGRAY);
                cells[r][c] = rect;
                gridPane.add(rect, c, r);
            }
        }

        // --- hint label ---
        Label hint = new Label("Arrow keys: move  |  Space: toggle  |  Button: generate code");
        hint.setStyle("-fx-text-fill: #cccccc; -fx-font-size: 12;");

        // --- "Create Code" button ---
        Button createCodeBtn = new Button("Create Code");
        createCodeBtn.setStyle("-fx-font-size: 13; -fx-padding: 6 18;");
        createCodeBtn.setOnAction(e -> {
            generateCode.execute();
            // refocus the scene so keyboard still works
            createCodeBtn.getScene().getRoot().requestFocus();
        });

        // --- layout ---
        VBox root = new VBox(10, gridPane, hint, createCodeBtn);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: #222222;");

        Scene scene = new Scene(root);

        // --- keyboard handler (Invoker logic) ---
        scene.setOnKeyPressed(event -> {
            KeyCode key = event.getCode();

            if (key == KeyCode.UP) {
                moveUp.execute();
            } else if (key == KeyCode.DOWN) {
                moveDown.execute();
            } else if (key == KeyCode.LEFT) {
                moveLeft.execute();
            } else if (key == KeyCode.RIGHT) {
                moveRight.execute();
            } else if (key == KeyCode.SPACE) {
                togglePixel.execute();
                event.consume(); // prevent scroll on space
            }

            refreshView();
        });

        // draw initial state
        refreshView();

        stage.setTitle("Pixel Art Editor");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        // scene needs focus for key events
        root.requestFocus();
    }

    /**
     * Redraws every cell to reflect the current grid state and cursor position.
     * Called after each command execution.
     */
    private void refreshView() {
        int curRow = grid.getCursorRow();
        int curCol = grid.getCursorCol();

        for (int r = 0; r < grid.getSize(); r++) {
            for (int c = 0; c < grid.getSize(); c++) {
                Rectangle rect = cells[r][c];

                // pixel colour: white = on, dark grey = off
                rect.setFill(grid.isPixelOn(r, c) ? Color.WHITE : Color.web("#444444"));

                // cursor: cyan border
                if (r == curRow && c == curCol) {
                    rect.setStroke(Color.CYAN);
                    rect.setStrokeWidth(BORDER);
                } else {
                    rect.setStroke(null);
                    rect.setStrokeWidth(0);
                }
            }
        }
    }
}

