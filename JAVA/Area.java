import java.util.Scanner;

public class Area {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Length: ");
        double length = sc.nextDouble();

        System.out.print("Enter Breadth: ");
        double breadth = sc.nextDouble();

        double area = length * breadth;

        System.out.println("Area of Rectangle = " + area);

        sc.close();
    }
}