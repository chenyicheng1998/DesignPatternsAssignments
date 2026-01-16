/**
 * Abstract base class for all button UI elements.
 * Defines the common interface and setText functionality.
 */
public abstract class Button {
    protected String text;

    public Button(String text) {
        this.text = text;
    }

    /**
     * Display the button using ASCII art.
     */
    public abstract void display();

    /**
     * Change the text content of the button.
     * @param text the new text to display
     */
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
