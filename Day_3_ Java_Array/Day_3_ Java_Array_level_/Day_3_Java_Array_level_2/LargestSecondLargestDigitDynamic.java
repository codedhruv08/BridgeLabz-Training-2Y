import java.util.Scanner;

public class LargestSecondLargestDigitDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int temp = number;

        while (temp != 0) {
            if (index == maxDigit) {
                maxDigit += 10;
                int[] tempArr = new int[maxDigit];
                for (int i = 0; i < index; i++) {
                    tempArr[i] = digits[i];
                }
                digits = tempArr;
            }
            digits[index++] = temp % 10;
            temp /= 10;
        }

        int largest = 0;
        int secondLargest = 0;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
}
