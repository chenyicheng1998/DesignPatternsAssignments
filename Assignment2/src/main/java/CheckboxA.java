/**
 * Checkbox implementation with Style A (classic rectangular style).
 * Uses '[ ]' for the checkbox and displays text next to it.
 */
public class CheckboxA extends Checkbox {

    public CheckboxA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("+---------+");
        System.out.println("| [ ] " + text);
        System.out.println("+---------+");
    }
}
