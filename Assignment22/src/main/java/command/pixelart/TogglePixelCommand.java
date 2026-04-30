package command.pixelart;

/** Toggles the pixel at the cursor's current position on or off. */
public class TogglePixelCommand implements Command {

    private final PixelGrid grid;

    public TogglePixelCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        grid.togglePixel();
    }
}

