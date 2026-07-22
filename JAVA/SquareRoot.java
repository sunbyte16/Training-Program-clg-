import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input first number
        System.out.print("Enter the first number: ");
        double number1 = scanner.nextDouble();

        // Input second number
        System.out.print("Enter the second number: ");
        double number2 = scanner.nextDouble();

        // Calculate square roots
        double sqrt1 = Math.sqrt(number1);
        double sqrt2 = Math.sqrt(number2);

        // Output the results
        System.out.println("The square root of " + number1 + " is: " + sqrt1);
        System.out.println("The square root of " + number2 + " is: " + sqrt2);

        scanner.close();
    }
}
