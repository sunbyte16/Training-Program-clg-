import java.util.Scanner;

class Sample{
    public static void main(String[] args){
        double a, b, c;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number1: ");
        a = sc.nextDouble();

        System.out.print("Enter a number2: ");
        b = sc.nextDouble();

        System.out.print("Enter a number3: ");
        c = sc.nextDouble();
        
        System.out.println("The maximum number is: " + Math.max(a, Math.max(b, c)));
               sc.close();
    }
}
