import java.util.Scanner;

public class ShareCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total candies: ");
        int candies = sc.nextInt();

        System.out.print("Enter number of friends: ");
        int friends = sc.nextInt();

        int eachFriend = candies / friends;
        int remaining = candies % friends;

        System.out.println("Each friend gets = " + eachFriend);
        System.out.println("Candies left = " + remaining);

        sc.close();
    }
}