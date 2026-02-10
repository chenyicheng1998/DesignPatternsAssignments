import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║  GAME CHARACTER DEVELOPMENT SYSTEM         ║");
        System.out.println("║  State Pattern Implementation              ║");
        System.out.println("╚════════════════════════════════════════════╝");

        System.out.print("\nEnter your character's name: ");
        String name = scanner.nextLine();

        GameCharacter character = new GameCharacter(name);
        character.play();

        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║  Thank you for playing!                    ║");
        System.out.println("╚════════════════════════════════════════════╝");

        scanner.close();
    }
}

