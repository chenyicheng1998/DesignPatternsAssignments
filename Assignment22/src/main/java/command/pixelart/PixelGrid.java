package command.pixelart;

/**
 * Receiver in the Command pattern.
 * Holds the 8x8 pixel grid state and the current cursor position.
 * Commands call methods on this object to perform the actual work.
 */
public class PixelGrid {

    private static final int SIZE = 8;

    private final boolean[][] pixels = new boolean[SIZE][SIZE];
    private int cursorRow = 0;
    private int cursorCol = 0;

    // --- cursor movement (wrap-around not used; cursor stops at edges) ---

    public void moveCursorUp() {
        if (cursorRow > 0) cursorRow--;
    }

    public void moveCursorDown() {
        if (cursorRow < SIZE - 1) cursorRow++;
    }

    public void moveCursorLeft() {
        if (cursorCol > 0) cursorCol--;
    }

    public void moveCursorRight() {
        if (cursorCol < SIZE - 1) cursorCol++;
    }

    /** Toggles the pixel at the current cursor position on/off. */
    public void togglePixel() {
        pixels[cursorRow][cursorCol] = !pixels[cursorRow][cursorCol];
    }

    /**
     * Returns a Java code snippet representing the current grid state
     * as a 2D int array (1 = on, 0 = off).
     */
    public String generateCode() {
        StringBuilder sb = new StringBuilder();
        sb.append("int[][] pixelArt = {\n");
        for (int r = 0; r < SIZE; r++) {
            sb.append("    {");
            for (int c = 0; c < SIZE; c++) {
                sb.append(pixels[r][c] ? 1 : 0);
                if (c < SIZE - 1) sb.append(", ");
            }
            sb.append("}");
            if (r < SIZE - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("};");
        return sb.toString();
    }

    // --- accessors used by the view ---

    public boolean isPixelOn(int row, int col) {
        return pixels[row][col];
    }

    public int getCursorRow() { return cursorRow; }
    public int getCursorCol() { return cursorCol; }
    public int getSize()      { return SIZE; }
}

