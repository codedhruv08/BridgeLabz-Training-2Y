import java.util.Scanner;

public class StoreValuesUntilNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] values = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double input = sc.nextDouble();

            if (input <= 0 || index == 10) {
                break;
            }

            values[index] = input;
            index++;
        }

        for (int i = 0; i < index; i++) {
            total += values[i];
            System.out.println("Value " + (i + 1) + ": " + values[i]);
        }

        System.out.println("Total: " + total);
    }
}
