// import java.util.Scanner;
// class SwapNumbers {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter First Number: ");
//         int a = sc.nextInt();
//         System.out.print("Enter Second Number: ");
//         int b = sc.nextInt();
//         // Swapping
//         int temp = a;
//         a = b;
//         b = temp;
//         System.out.println("After Swapping:");
//         System.out.println("First Number = " + a);
//         System.out.println("Second Number = " + b);
//         sc.close();
//     }
// }




// import java.util.Scanner;
// class SwapNumbers {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter First Number: ");
//         int a = sc.nextInt();
//         System.out.print("Enter Second Number: ");
//         int b = sc.nextInt();
//         // Swap in one line
//         int temp = a; a = b; b = temp;
//         System.out.println("First Number = " + a);
//         System.out.println("Second Number = " + b);
//         sc.close();
//     }
// }

// import java.util.Scanner;
// class SwapNumbers {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter First Number: ");
//         int a = sc.nextInt();
//         System.out.print("Enter Second Number: ");
//         int b = sc.nextInt();
//         // Swap without temp variable
//         a = a + b;
//         b = a - b;
//         a = a - b;
//         System.out.println("After Swapping:");
//         System.out.println("First Number = " + a);
//         System.out.println("Second Number = " + b);
//         sc.close();
//     }
// }



import java.util.Scanner;

class SwapNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Number: ");
        int a = sc.nextInt();

        System.out.print("Enter Second Number: ");
        int b = sc.nextInt();

        // Swap two numbers without temp variable
        //initially here we take values 
        // a= 10
        // b= 20
        a=a+b-(b=a);//Here "(b=a)" does two things
        //After evaluating we get this:
        //a=30-10=20
        //b=10

        System.out.println("After Swapping:");
        System.out.println("First Number = " + a);
        System.out.println("Second Number = " + b);
        sc.close();
    }
}




