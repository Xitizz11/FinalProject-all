import java.util.Scanner;

public class InputValidator {
    public static int getIntInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = scanner.next();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter an integer.");
            return getIntInput(); // Recursive call
        }
    }
}
