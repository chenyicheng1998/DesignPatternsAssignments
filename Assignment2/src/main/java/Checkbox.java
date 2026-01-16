/**
 * Abstract base class for all checkbox UI elements.
 * Defines the common interface and setText functionality.
 */
public abstract class Checkbox {
    protected String text;

    public Checkbox(String text) {
        this.text = text;
    }

    /**
     * Display the checkbox using ASCII art.
     */
    public abstract void display();

    /**
     * Change the text content of the checkbox.
     * @param text the new text to display
     */
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
