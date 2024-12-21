package src;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int numberToGuess = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("A number between " + RANGE_MIN + " and " + RANGE_MAX + " has been generated.");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                }

                if (attempts == MAX_ATTEMPTS && !guessedCorrectly) {
                    System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("Thank you for playing!");
        scanner.close();
    }
}