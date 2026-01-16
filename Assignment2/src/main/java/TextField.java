/**
 * Abstract base class for all text field UI elements.
 * Defines the common interface and setText functionality.
 */
public abstract class TextField {
    protected String text;

    public TextField(String text) {
        this.text = text;
    }

    /**
     * Display the text field using ASCII art.
     */
    public abstract void display();

    /**
     * Change the text content of the text field.
     * @param text the new text to display
     */
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
