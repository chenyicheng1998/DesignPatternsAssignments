/**
 * TextField implementation with Style A (classic rectangular style).
 * Uses '-' for borders and displays text left-aligned.
 */
public class TextFieldA extends TextField {

    public TextFieldA(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = Math.max(text.length() + 4, 20);
        String border = "-".repeat(width);
        String rightPad = " ".repeat(width - text.length() - 3);

        System.out.println(border);
        System.out.println("| " + text + rightPad + "|");
        System.out.println(border);
    }
}
