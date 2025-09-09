import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentages = new double[n];
        char[] grades = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for student " + (i + 1) + " in Physics: ");
            int p = sc.nextInt();
            System.out.print("Enter marks for student " + (i + 1) + " in Chemistry: ");
            int c = sc.nextInt();
            System.out.print("Enter marks for student " + (i + 1) + " in Maths: ");
            int m = sc.nextInt();

            if (p < 0 || c < 0 || m < 0) {
                System.out.println("Invalid marks, enter again.");
                i--;
                continue;
            }

            physics[i] = p;
            chemistry[i] = c;
            maths[i] = m;
        }

        for (int i = 0; i < n; i++) {
            percentages[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
            if (percentages[i] >= 90) grades[i] = 'A';
            else if (percentages[i] >= 80) grades[i] = 'B';
            else if (percentages[i] >= 70) grades[i] = 'C';
            else if (percentages[i] >= 60) grades[i] = 'D';
            else grades[i] = 'F';
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": Physics=" + physics[i] + ", Chemistry=" + chemistry[i] + ", Maths=" + maths[i] + ", Percentage=" + percentages[i] + ", Grade=" + grades[i]);
        }
    }
}
