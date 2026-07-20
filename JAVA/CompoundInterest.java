import java.util.Scanner;

class CompoundInterest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter Principal Amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter Rate of Interest (%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = sc.nextDouble();

        // Calculate Amount
        double amount = principal * Math.pow((1 + rate / 100), time);

        // Calculate Compound Interest
        double compoundInterest = amount - principal;

        // Output
        System.out.println("\nAmount = " + amount);
        System.out.println("Compound Interest = " + compoundInterest);

        sc.close();
    }
}