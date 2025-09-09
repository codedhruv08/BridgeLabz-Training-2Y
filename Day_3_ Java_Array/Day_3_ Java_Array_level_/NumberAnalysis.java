import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        for (int n : numbers) {
            if (n > 0) {
                if (n % 2 == 0) {
                    System.out.println(n + " is a positive even number");
                } else {
                    System.out.println(n + " is a positive odd number");
                }
            } else if (n < 0) {
                System.out.println(n + " is a negative number");
            } else {
                System.out.println("Number is zero");
            }
        }

        if (numbers[0] == numbers[4]) {
            System.out.println("First and last elements are equal");
        } else if (numbers[0] > numbers[4]) {
            System.out.println("First element is greater than last element");
        } else {
            System.out.println("First element is less than last element");
        }
    }
}
