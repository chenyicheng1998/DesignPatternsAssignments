package command.pixelart;

/**
 * Command interface for the pixel art editor.
 * Each action (move cursor, toggle pixel, generate code) is encapsulated as a Command.
 */
public interface Command {
    void execute();
}

