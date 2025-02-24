import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        // Take input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        // Check if the string is a palindrome
        if (isPalindrome(input)) {
            System.out.println(input + " is a palindrome.");
        } else {
            System.out.println(input + " is not a palindrome.");
        }
    }

    public static boolean isPalindrome(String str) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize two pointers
        int left = 0;
        int right = cleanedStr.length() - 1;

        // Compare characters from both ends
        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }

        return true; // It is a palindrome
    }
}