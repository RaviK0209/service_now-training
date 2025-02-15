import java.util.Scanner;

public class MobileNumberOtp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter mobile number: ");
        String mobileNumber = sc.nextLine();

        // Validate mobile number length
        if (mobileNumber.length() < 6 || mobileNumber.length() > 10) {
            System.out.println("Invalid mobile number");
        } else {
            StringBuilder otpString = new StringBuilder();

            // Iterate through the mobile number
            for (int i = 0; i < mobileNumber.length(); i++) {
                // Check for odd positions (2nd, 4th, 6th, etc.)
                if (i % 2 == 1) {
                    char digitChar = mobileNumber.charAt(i);
                    int digit = Character.getNumericValue(digitChar); // Convert char to int
                    int squaredDigit = digit * digit; // Square the digit
                    otpString.append(squaredDigit); // Append to OTP string
                }
            }

            // Take the first 4 characters of the OTP string
            String otp = otpString.length() >= 4 ? otpString.substring(0, 4) : otpString.toString();
            System.out.println("Generated OTP: " + otp);
        }

        sc.close();
    }
}