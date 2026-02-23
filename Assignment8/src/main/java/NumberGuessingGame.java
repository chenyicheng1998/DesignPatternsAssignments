import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame extends Game {
    private Player[] players;
    private int targetNumber;
    private int maxRounds;
    private int currentRound;
    private Random random;
    private Scanner scanner;

    @Override
    public void initializeGame(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        scanner = new Scanner(System.in);
        random = new Random();

        System.out.println("=== Number Guessing Game ===");
        System.out.println("Welcome! Each round, guess a number between 1 and 10.");
        System.out.println();

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Enter name for Player " + (i + 1) + ": ");
            String name = scanner.nextLine();
            players[i] = new Player(name);
        }

        System.out.print("\nHow many rounds to play? ");
        maxRounds = scanner.nextInt();
        scanner.nextLine();

        currentRound = 0;
        System.out.println("\nLet's start!\n");
    }

    @Override
    public boolean endOfGame() {
        return currentRound >= maxRounds;
    }

    @Override
    public void playSingleTurn(int player) {
        if (player == 0) {
            currentRound++;
            targetNumber = random.nextInt(10) + 1;
            System.out.println("--- Round " + currentRound + " ---");
        }

        Player currentPlayer = players[player];
        System.out.print(currentPlayer.getName() + ", guess a number (1-10): ");

        int guess = scanner.nextInt();
        scanner.nextLine();

        if (guess == targetNumber) {
            System.out.println("Correct! " + currentPlayer.getName() + " gets a point!");
            currentPlayer.addPoint();
        } else {
            System.out.println("Wrong! The number was " + targetNumber);
        }

        System.out.println();
    }

    @Override
    public void displayWinner() {
        System.out.println("=== Game Over ===");
        System.out.println("Final Scores:");

        int maxScore = -1;
        Player winner = null;

        for (Player player : players) {
            System.out.println(player.getName() + ": " + player.getScore() + " points");
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println("\nWinner: " + winner.getName() + " with " + maxScore + " points!");
        }
        scanner.close();
    }
}


