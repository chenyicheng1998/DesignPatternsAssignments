package command.pixelart;

/** Moves the cursor one column to the left. */
public class MoveCursorLeftCommand implements Command {

    private final PixelGrid grid;

    public MoveCursorLeftCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursorLeft();
    }
}

