void main() {
    Scanner sc = new Scanner(System.in);

    IO.print("Enter Principal Amount (P): ");
    double P = sc.nextDouble();

    IO.print("Enter Rate of Interest (R): ");
    double R = sc.nextDouble();

    IO.print("Enter Number of Years (n): ");
    double n = sc.nextDouble();

    double I = P * Math.pow((1 + R / 100), n) - P;

    IO.println("Compound Interest = " + I);

    sc.close();
}
