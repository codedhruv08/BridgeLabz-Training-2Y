import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int count = 0, temp = number;
        while (temp != 0) {
            temp /= 10;
            count++;
        }

        int[] digits = new int[count];
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        int[] frequency = new int[10];
        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Digit " + i + ": " + frequency[i]);
        }
    }
}
