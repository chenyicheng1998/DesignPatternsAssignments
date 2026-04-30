package command.pixelart;

/** Moves the cursor one row up. */
public class MoveCursorUpCommand implements Command {

    private final PixelGrid grid;

    public MoveCursorUpCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.moveCursorUp();
    }
}

