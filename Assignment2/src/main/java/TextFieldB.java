/**
 * TextField implementation with Style B (rounded decorative style).
 * Uses '~' for borders and displays text with rounded corners.
 */
public class TextFieldB extends TextField {

    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = Math.max(text.length() + 4, 20);
        String border = "~".repeat(width);
        String rightPad = " ".repeat(width - text.length() - 4);

        System.out.println(" " + border);
        System.out.println("( " + text + rightPad + " )");
        System.out.println(" " + border);
    }
}
