/**
 * Example demonstrating how to easily extend the Abstract Factory pattern
 * with a new UI style (Style C - Minimalist).
 *
 * This shows the Open/Closed Principle in action:
 * - Open for extension: We can add new styles without modifying existing code
 * - Closed for modification: Existing factories and UI elements remain unchanged
 */

// Uncomment the following classes to add a third UI style:

/*
// Style C - Minimalist style with simple borders

class ButtonC extends Button {
    public ButtonC(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("[" + text + "]");
    }
}

class TextFieldC extends TextField {
    public TextFieldC(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("_" + text + "_");
    }
}

class CheckboxC extends Checkbox {
    public CheckboxC(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("☐ " + text);
    }
}

class CFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonC(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldC(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxC(text);
    }
}
*/

/**
 * Usage example for Style C:
 *
 * UIFactory factoryC = new CFactory();
 * Button buttonC = factoryC.createButton("OK");
 * buttonC.display();  // Output: [OK]
 *
 * TextField textFieldC = factoryC.createTextField("Type here");
 * textFieldC.display();  // Output: _Type here_
 *
 * Checkbox checkboxC = factoryC.createCheckbox("Enable");
 * checkboxC.display();  // Output: ☐ Enable
 */

public class ExtensionExample {
    // This class demonstrates how easy it is to extend the pattern
    // Simply uncomment the code above and add the new factory to your main method!
}
