/**
 * Button implementation with Style B (rounded decorative style).
 * Uses '*' for borders and displays text with decorative elements.
 */
public class ButtonB extends Button {

    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        int width = Math.max(text.length() + 6, 14);
        String topBorder = " " + "*".repeat(width - 2);
        String bottomBorder = " " + "*".repeat(width - 2);
        int padding = (width - text.length() - 4) / 2;
        String leftPad = " ".repeat(padding);
        String rightPad = " ".repeat(width - text.length() - padding - 4);

        System.out.println(topBorder);
        System.out.println("*" + leftPad + "< " + text + " >" + rightPad + "*");
        System.out.println(bottomBorder);
    }
}
