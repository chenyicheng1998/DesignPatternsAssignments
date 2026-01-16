/**
 * Abstract Factory for creating UI elements.
 * Defines methods for creating buttons, text fields, and checkboxes.
 */
public abstract class UIFactory {

    /**
     * Create a button with the specified text.
     * @param text the text to display on the button
     * @return a Button instance
     */
    public abstract Button createButton(String text);

    /**
     * Create a text field with the specified text.
     * @param text the text to display in the text field
     * @return a TextField instance
     */
    public abstract TextField createTextField(String text);

    /**
     * Create a checkbox with the specified text.
     * @param text the text to display next to the checkbox
     * @return a Checkbox instance
     */
    public abstract Checkbox createCheckbox(String text);
}
