import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Recommendation> recommendationLibrary = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize with some sample recommendations
        initializeSampleRecommendations();

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntInput();

            switch (choice) {
                case 1:
                    viewAllRecommendations();
                    break;
                case 2:
                    createNewRecommendation();
                    break;
                case 3:
                    cloneAndModifyRecommendation();
                    break;
                case 4:
                    viewRecommendationDetails();
                    break;
                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void initializeSampleRecommendations() {
        // Create a recommendation for young adults
        Recommendation youngAdultRec = new Recommendation("Young Adults");
        youngAdultRec.addBook(new Book("The Hunger Games", "Suzanne Collins", "Dystopian", 2008));
        youngAdultRec.addBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 1997));
        youngAdultRec.addBook(new Book("The Fault in Our Stars", "John Green", "Romance", 2012));
        recommendationLibrary.add(youngAdultRec);

        // Create a recommendation for mystery lovers
        Recommendation mysteryRec = new Recommendation("Mystery Lovers");
        mysteryRec.addBook(new Book("The Da Vinci Code", "Dan Brown", "Mystery", 2003));
        mysteryRec.addBook(new Book("Gone Girl", "Gillian Flynn", "Thriller", 2012));
        mysteryRec.addBook(new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", "Mystery", 2005));
        recommendationLibrary.add(mysteryRec);

        // Create a recommendation for science fiction fans
        Recommendation sciFiRec = new Recommendation("Science Fiction Fans");
        sciFiRec.addBook(new Book("Dune", "Frank Herbert", "Science Fiction", 1965));
        sciFiRec.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        sciFiRec.addBook(new Book("The Martian", "Andy Weir", "Science Fiction", 2011));
        recommendationLibrary.add(sciFiRec);
    }

    private static void displayMenu() {
        System.out.println("\n=== Book Recommendation System ===");
        System.out.println("1. View all recommendations");
        System.out.println("2. Create new recommendation from scratch");
        System.out.println("3. Clone and modify existing recommendation");
        System.out.println("4. View recommendation details");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void viewAllRecommendations() {
        if (recommendationLibrary.isEmpty()) {
            System.out.println("\nNo recommendations available.");
            return;
        }

        System.out.println("\n=== All Recommendations ===");
        for (int i = 0; i < recommendationLibrary.size(); i++) {
            Recommendation rec = recommendationLibrary.get(i);
            System.out.println((i + 1) + ". " + rec.getTargetAudience() +
                             " (" + rec.getBookCount() + " books)");
        }
    }

    private static void createNewRecommendation() {
        System.out.print("\nEnter target audience: ");
        scanner.nextLine(); // consume newline
        String audience = scanner.nextLine();

        Recommendation newRec = new Recommendation(audience);

        boolean addingBooks = true;
        while (addingBooks) {
            System.out.print("Add a book? (y/n): ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("y")) {
                addBookToRecommendation(newRec);
            } else {
                addingBooks = false;
            }
        }

        recommendationLibrary.add(newRec);
        System.out.println("Recommendation created successfully!");
    }

    private static void cloneAndModifyRecommendation() {
        viewAllRecommendations();

        if (recommendationLibrary.isEmpty()) {
            return;
        }

        System.out.print("\nEnter the number of recommendation to clone: ");
        int index = getIntInput() - 1;

        if (index < 0 || index >= recommendationLibrary.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        Recommendation original = recommendationLibrary.get(index);
        Recommendation cloned = original.clone();

        System.out.println("\nCloned recommendation for: " + cloned.getTargetAudience());
        System.out.print("Enter new target audience (or press Enter to keep): ");
        scanner.nextLine(); // consume newline
        String newAudience = scanner.nextLine();

        if (!newAudience.trim().isEmpty()) {
            cloned.setTargetAudience(newAudience);
        }

        boolean modifying = true;
        while (modifying) {
            System.out.println("\n1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Finish and save");
            System.out.print("Choose action: ");
            int action = getIntInput();
            scanner.nextLine(); // consume newline

            switch (action) {
                case 1:
                    addBookToRecommendation(cloned);
                    break;
                case 2:
                    removeBookFromRecommendation(cloned);
                    break;
                case 3:
                    modifying = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        recommendationLibrary.add(cloned);
        System.out.println("Modified recommendation saved!");
    }

    private static void viewRecommendationDetails() {
        viewAllRecommendations();

        if (recommendationLibrary.isEmpty()) {
            return;
        }

        System.out.print("\nEnter the number of recommendation to view: ");
        int index = getIntInput() - 1;

        if (index < 0 || index >= recommendationLibrary.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        System.out.println("\n" + recommendationLibrary.get(index));
    }

    private static void addBookToRecommendation(Recommendation rec) {
        System.out.print("Book title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Publication year: ");
        int year = getIntInput();
        scanner.nextLine(); // consume newline

        rec.addBook(new Book(title, author, genre, year));
        System.out.println("Book added!");
    }

    private static void removeBookFromRecommendation(Recommendation rec) {
        System.out.println("\n" + rec);
        System.out.print("Enter book number to remove: ");
        int bookIndex = getIntInput() - 1;
        scanner.nextLine(); // consume newline

        if (bookIndex >= 0 && bookIndex < rec.getBookCount()) {
            rec.removeBook(bookIndex);
            System.out.println("Book removed!");
        } else {
            System.out.println("Invalid book number.");
        }
    }

    private static int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}

