package command.pixelart;

/** Moves the cursor one row down. */
public class MoveCursorDownCommand implements Command {

    private final PixelGrid grid;

    public MoveCursorDownCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursorDown();
    }
}

