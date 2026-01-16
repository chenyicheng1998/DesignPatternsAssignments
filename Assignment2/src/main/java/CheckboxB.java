/**
 * Checkbox implementation with Style B (rounded decorative style).
 * Uses '( )' for the checkbox and displays text with decorative elements.
 */
public class CheckboxB extends Checkbox {

    public CheckboxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("  .~~~~~~~~~.");
        System.out.println(" /  ( ) " + text);
        System.out.println("  '~~~~~~~~~'");
    }
}
