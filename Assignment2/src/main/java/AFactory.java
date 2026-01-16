/**
 * Concrete Factory for creating UI elements with Style A.
 * Creates ButtonA, TextFieldA, and CheckboxA instances.
 */
public class AFactory extends UIFactory {

    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }
}
