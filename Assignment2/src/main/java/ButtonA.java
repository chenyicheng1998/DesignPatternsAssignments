/**
 * Button implementation with Style A (classic rectangular style).
 * Uses '=' for borders and displays text centered.
 */
public class ButtonA extends Button {

    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = Math.max(text.length() + 4, 12);
        String border = "=".repeat(width);
        int padding = (width - text.length() - 2) / 2;
        String leftPad = " ".repeat(padding);
        String rightPad = " ".repeat(width - text.length() - padding - 2);

        System.out.println(border);
        System.out.println("=" + leftPad + text + rightPad + "=");
        System.out.println(border);
    }
}
