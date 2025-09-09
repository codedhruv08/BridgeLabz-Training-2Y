import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
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

            marks[i][0] = p;
            marks[i][1] = c;
            marks[i][2] = m;
        }

        for (int i = 0; i < n; i++) {
            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
            if (percentages[i] >= 90) grades[i] = 'A';
            else if (percentages[i] >= 80) grades[i] = 'B';
            else if (percentages[i] >= 70) grades[i] = 'C';
            else if (percentages[i] >= 60) grades[i] = 'D';
            else grades[i] = 'F';
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": Physics=" + marks[i][0] + ", Chemistry=" + marks[i][1] + ", Maths=" + marks[i][2] + ", Percentage=" + percentages[i] + ", Grade=" + grades[i]);
        }
    }
}
