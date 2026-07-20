import java.util.Scanner;
class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter marks of Subject 1: ");
        float sub1 = sc.nextFloat();
        System.out.print("Enter marks of Subject 2: ");
        float sub2 = sc.nextFloat();
        System.out.print("Enter marks of Subject 3: ");
        float sub3 = sc.nextFloat();
        System.out.print("Enter marks of Subject 4: ");
        float sub4 = sc.nextFloat();
        System.out.print("Enter marks of Subject 5: ");
        float sub5 = sc.nextFloat();
        // Calculate Total and Average
        float total = sub1 + sub2 + sub3 + sub4 + sub5;
        float average = total / 5;
        System.out.println("\n Total Marks = " + total);
        System.out.println("Average Marks = " + average);
        // Check Pass or Fail
        if (sub1 < 40 || sub2 < 40 || sub3 < 40 || sub4 < 40 || sub5 < 40) {
            System.out.println("Result : FAIL");
            System.out.println("Sorry! You have failed the examination.");
        } else {
            System.out.println("Result : PASS");
            System.out.println("Congratulations! You have passed the exam.");
        }
        sc.close();
    }
}





