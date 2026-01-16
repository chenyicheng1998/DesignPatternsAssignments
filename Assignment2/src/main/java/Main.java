/**
 * Main class to demonstrate the Abstract Factory pattern with ASCII art UI elements.
 * Creates UI elements using different factories and demonstrates the setText functionality.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("ASCII Art UI Factory Demo");
        System.out.println("========================================\n");

        // Create UI elements with Style A (AFactory)
        System.out.println("Creating UI elements with Style A (Classic Rectangular):");
        System.out.println("--------------------------------------------------");
        UIFactory factoryA = new AFactory();

        Button buttonA = factoryA.createButton("Submit");
        TextField textFieldA = factoryA.createTextField("Enter your name");
        Checkbox checkboxA = factoryA.createCheckbox("Accept Terms");

        System.out.println("\nButton A:");
        buttonA.display();

        System.out.println("\nTextField A:");
        textFieldA.display();

        System.out.println("\nCheckbox A:");
        checkboxA.display();

        System.out.println("\n\n========================================\n");

        // Create UI elements with Style B (BFactory)
        System.out.println("Creating UI elements with Style B (Rounded Decorative):");
        System.out.println("--------------------------------------------------");
        UIFactory factoryB = new BFactory();

        Button buttonB = factoryB.createButton("Cancel");
        TextField textFieldB = factoryB.createTextField("Search here");
        Checkbox checkboxB = factoryB.createCheckbox("Remember me");

        System.out.println("\nButton B:");
        buttonB.display();

        System.out.println("\nTextField B:");
        textFieldB.display();

        System.out.println("\nCheckbox B:");
        checkboxB.display();

        System.out.println("\n\n========================================\n");

        // Demonstrate setText functionality
        System.out.println("Demonstrating setText() functionality:");
        System.out.println("--------------------------------------------------");

        System.out.println("\nOriginal Button A:");
        buttonA.display();

        System.out.println("\nChanging button text to 'Click Me!'...");
        buttonA.setText("Click Me!");

        System.out.println("\nUpdated Button A:");
        buttonA.display();

        System.out.println("\n\nOriginal TextField B:");
        textFieldB.display();

        System.out.println("\nChanging text field content to 'New search query'...");
        textFieldB.setText("New search query");

        System.out.println("\nUpdated TextField B:");
        textFieldB.display();

        System.out.println("\n\nOriginal Checkbox A:");
        checkboxA.display();

        System.out.println("\nChanging checkbox label to 'Subscribe to newsletter'...");
        checkboxA.setText("Subscribe to newsletter");

        System.out.println("\nUpdated Checkbox A:");
        checkboxA.display();

        System.out.println("\n========================================");
        System.out.println("Demo completed!");
        System.out.println("========================================");
    }
}
