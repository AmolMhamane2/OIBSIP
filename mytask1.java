import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Author:
 * @Amol Mhamane
 * Oasis Infobyte Internship
 */
public class mytask1 {
    public static void main(String[] args) {
        System.out.println("Let's Start the game... I will generate a number between");
        System.out.println("1 and 100, and you try to guess it.");

        Scanner scanner = new Scanner(System.in);

        boolean playAgain;

        do {
            playGame();

            // Get the user choice whether they want to play again..?
            System.out.println("Would you like to play again? Y/N");

            // get the user's input as a string and convert it to a boolean value
            String playAgainStr = scanner.next();
            playAgain = playAgainStr.equalsIgnoreCase("Y");
        } while (playAgain);

        System.out.println("Hope you enjoyed the game.... Thanks for playing..... Goodbye");
    }

    static void playGame() {
        int computerNumber;
        int userGuess;
        int guessCount; // Counts the number of guesses of the user

        // Create a random number between 1 and 100
        computerNumber = (int) (100 * Math.random()) + 1;

        guessCount = 0;

        System.out.println();
        System.out.println("Enter your guess ?");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                userGuess = scanner.nextInt();
                guessCount++;

                if (userGuess == computerNumber) {
                    System.out.println("You got it in " + guessCount + " guesses! My number was " + computerNumber);
                    break;
                }

                if (guessCount == 6) {
                    System.out.println("You didn't get the number in 6 guesses.");
                    System.out.println("You lose. My number was " + computerNumber);
                    break;
                }

                if (userGuess < computerNumber) {
                    System.out.println("Your number is too low. Try again:");
                } else if (userGuess > computerNumber) {
                    System.out.println("Your number is too high. Try again:");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
        }

        System.out.println();
    }
}
