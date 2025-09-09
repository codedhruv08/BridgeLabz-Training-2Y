import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] years = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            double salary = sc.nextDouble();
            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            double year = sc.nextDouble();
            if (salary < 0 || year < 0) {
                System.out.println("Invalid input, enter again.");
                i--;
            } else {
                salaries[i] = salary;
                years[i] = year;
            }
        }

        for (int i = 0; i < 10; i++) {
            double bonusPercent = years[i] > 5 ? 0.05 : 0.02;
            bonuses[i] = salaries[i] * bonusPercent;
            newSalaries[i] = salaries[i] + bonuses[i];
            totalBonus += bonuses[i];
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        System.out.println("Total bonus payout: " + totalBonus);
        System.out.println("Total old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);
    }
}
