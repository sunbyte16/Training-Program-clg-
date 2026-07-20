import java.util.Scanner;
class RectAnguler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length: ");
        float length = sc.nextFloat();
        System.out.print("Enter Breadth: ");
        float breadth = sc.nextFloat();
        // Calculate Area
        float area = length * breadth;
        // Calculate Perimeter
        float perimeter = 2 * (length + breadth);
        System.out.println("Area of Rectangle = " + area);
        System.out.println("Perimeter of Rectangle = " + perimeter);

        sc.close();
    }
}