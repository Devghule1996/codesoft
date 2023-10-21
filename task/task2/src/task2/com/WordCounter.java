package task2.com;

import java.util.*;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter '1' to input text or '2' to provide a file:");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String text = "";

        if (choice == 1) {
            System.out.println("Enter the text:");
            text = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            text = readFile(filePath);
        } else {
            System.err.println("Invalid choice. Please enter '1' or '2'.");
            return;
        }

        int wordCount = countWords(text);
        System.out.println("Total word count: " + wordCount);

        scanner.close();
    }

    private static int countWords(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+");
        return words.length;
    }

    private static String readFile(String filePath) {
		return filePath;
        // Read the file content and return it as a string (you can use your previous 'readFile' method)
        // Implement error handling if the file doesn't exist or cannot be read
        // Return an empty string or handle the error as needed
    }
}


