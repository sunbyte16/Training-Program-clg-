import java.util.Scanner;
class CylinderVolume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Radius: ");
        double radius = sc.nextDouble();
        System.out.print("Enter Height: ");
        double height = sc.nextDouble();
        // Calculate Volume
        double volume = Math.PI * radius * radius * height;
        System.out.println("Volume of Cylinder = " + volume);
        sc.close();
    }
}