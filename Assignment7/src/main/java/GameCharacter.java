import java.util.Scanner;

public class GameCharacter {
    private String name;
    private int level;
    private int experiencePoints;
    private int healthPoints;
    private State state;
    private static Scanner scanner = new Scanner(System.in);

    public GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.experiencePoints = 0;
        this.healthPoints = 100;
        this.state = new NoviceState(this);
    }

    public void play() {
        System.out.println("\n===========================================");
        System.out.println("   Welcome to Character Development Game");
        System.out.println("===========================================\n");

        while (!(state instanceof MasterState)) {
            displayStatus();
            state.handleAction();
        }

        displayStatus();
        System.out.println("\n🎉 Congratulations! You've reached Master level!");
        System.out.println("Game completed successfully!");
    }

    public void displayStatus() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│      CHARACTER STATUS               │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ Name:       " + String.format("%-23s", name) + "│");
        System.out.println("│ Level:      " + String.format("%-23s", getLevelName()) + "│");
        System.out.println("│ Experience: " + String.format("%-23s", experiencePoints + " XP") + "│");
        System.out.println("│ Health:     " + String.format("%-23s", healthPoints + " HP") + "│");
        System.out.println("└─────────────────────────────────────┘");
    }

    public String getLevelName() {
        if (state instanceof NoviceState) return "Novice (Level 1)";
        if (state instanceof IntermediateState) return "Intermediate (Level 2)";
        if (state instanceof ExpertState) return "Expert (Level 3)";
        if (state instanceof MasterState) return "Master (Level 4)";
        return "Unknown";
    }

    public int readUserChoice(String[] options) {
        System.out.println("\nAvailable Actions:");
        for (int i = 0; i < options.length; i++) {
            System.out.println("  " + (i + 1) + ". " + options[i]);
        }
        System.out.print("\nChoose an action (1-" + options.length + "): ");

        try {
            int choice = scanner.nextInt();
            if (choice < 1 || choice > options.length) {
                System.out.println("❌ Invalid choice! Please try again.");
                return readUserChoice(options);
            }
            return choice;
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            System.out.println("❌ Invalid input! Please enter a number.");
            return readUserChoice(options);
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void addExperiencePoints(int points) {
        this.experiencePoints += points;
        System.out.println("✨ Gained " + points + " XP! Total: " + experiencePoints + " XP");
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void addHealthPoints(int points) {
        this.healthPoints += points;
        if (this.healthPoints > 100) {
            this.healthPoints = 100;
        }
        System.out.println("💚 Gained " + points + " HP! Total: " + healthPoints + " HP");
    }

    public void reduceHealthPoints(int points) {
        this.healthPoints -= points;
        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
        System.out.println("💔 Lost " + points + " HP! Remaining: " + healthPoints + " HP");
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

