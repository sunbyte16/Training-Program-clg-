import java.util.Scanner;

class PocketMoney{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter pocket money per week: ");
        double pocketMoney = sc.nextDouble();

        System.out.println("Enter number of week: ");
        int weeks = sc.nextInt();

        double totalSavings = pocketMoney * weeks;
        System.out.println("Total Saving = " + totalSavings);

        sc.close();
    }
}
