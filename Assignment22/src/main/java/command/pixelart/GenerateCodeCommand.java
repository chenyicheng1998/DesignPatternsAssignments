package command.pixelart;

/**
 * Generates Java source code that represents the current pixel art grid
 * as a 2D int array and prints it to the console.
 */
public class GenerateCodeCommand implements Command {

    private final PixelGrid grid;

    public GenerateCodeCommand(PixelGrid grid) {
        this.grid = grid;
    }

    @Override
    public void execute() {
        System.out.println("--- Generated pixel art code ---");
        System.out.println(grid.generateCode());
        System.out.println("--------------------------------");
    }
}

