package Task.com;

	import java.util.Random;
	import java.util.Scanner;

	public class NumberGuessingGame {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        int minRange = 1;
	        int maxRange = 100;
	        int maxAttempts = 10;
	        int rounds = 0;
	        int score = 0;

	        System.out.println("Welcome to the Number Guessing Game!");

	        do {
	            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
	            int attempts = 0;
	            boolean hasGuessedCorrectly = false;

	            System.out.println("\nRound " + (rounds + 1));
	            System.out.println("Guess the number between " + minRange + " and " + maxRange + ".");
	            System.out.println("You have " + maxAttempts + " attempts.");

	            while (attempts < maxAttempts) {
	                System.out.print("Enter your guess: ");
	                int userGuess = scanner.nextInt();
	                attempts++;

	                if (userGuess == targetNumber) {
	                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
	                    hasGuessedCorrectly = true;
	                    score += maxAttempts - attempts + 1;
	                    break;
	                } else if (userGuess < targetNumber) {
	                    System.out.println("Too low. Try again.");
	                } else {
	                    System.out.println("Too high. Try again.");
	                }
	            }

	            if (!hasGuessedCorrectly) {
	                System.out.println("Out of attempts. The correct number was " + targetNumber + ".");
	            }

	            rounds++;

	            System.out.print("Do you want to play again? (yes/no): ");
	            String playAgain = scanner.next().toLowerCase();
	            if (!playAgain.equals("yes")) {
	                break;
	            }
	        } while (true);

	        System.out.println("Game Over!");
	        System.out.println("Total Rounds: " + rounds);
	        System.out.println("Total Score: " + score);

	        scanner.close();
	    }
	}



