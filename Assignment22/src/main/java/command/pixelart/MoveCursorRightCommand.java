package command.pixelart;

/** Moves the cursor one column to the right. */
public class MoveCursorRightCommand implements Command {

    private final PixelGrid grid;

    public MoveCursorRightCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursorRight();
    }
}

