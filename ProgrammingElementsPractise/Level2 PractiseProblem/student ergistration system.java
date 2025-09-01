import java.util.Scanner;

public class StudentRegistrationSystem {

    // Reusable method to display all students
    public static void displayStudents(String[] students) {
        System.out.println("\n--- Registered Students ---");
        for (String student : students) {
            System.out.println(student);
        }
    }

    // Reusable method to compare two Strings
    public static void compareStrings(String s1, String s2) {
        System.out.println("\nComparing \"" + s1 + "\" and \"" + s2 + "\":");
        System.out.println("Using == : " + (s1 == s2));
        System.out.println("Using equals() : " + s1.equals(s2));
    }

    // Search method
    public static void searchStudent(String[] students, String name) {
        boolean found = false;
        for (String student : students) {
            if (student.equalsIgnoreCase(name)) {  // case-insensitive match
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(name + " -> Student Registered");
        } else {
            System.out.println(name + " -> Student Not Found");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] students = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name " + (i + 1) + ": ");
            students[i] = sc.nextLine();
        }

        // Step 2: Display students using reusable method
        displayStudents(students);

        // Step 3: Show SCP behavior
        String s1 = "Java";
        String s2 = "Java";     // Points to same SCP object as s1
        String s3 = new String("Java"); // Creates new object in heap

        compareStrings(s1, s2); // true for == and equals
        compareStrings(s1, s3); // false for ==, true for equals

        // Step 4: Demonstrate immutability
        String original = students[0];
        String modified = original.concat(" Kumar"); // new object
        System.out.println("\nOriginal: " + original);
        System.out.println("After concat: " + modified);

        // Step 5: Search student
        System.out.print("\nEnter name to search: ");
        String searchName = sc.nextLine();
        searchStudent(students, searchName);

        // Step 6: StringBuffer & StringBuilder demonstration
        System.out.println("\n--- StringBuffer & StringBuilder Demo ---");

        StringBuffer sbf = new StringBuffer(students[0]); // thread-safe
        sbf.append(" Singh");
        sbf.insert(0, "Mr. ");
        sbf.delete(3, 6);
        System.out.println("Modified with StringBuffer: " + sbf);

        StringBuilder sbd = new StringBuilder(students[0]); // faster, not synchronized
        sbd.append(" Sharma");
        sbd.insert(0, "Dr. ");
        sbd.delete(3, 6);
        System.out.println("Modified with StringBuilder: " + sbd);

        System.out.println("\nNote: StringBuffer is thread-safe (synchronized), "
                + "while StringBuilder is faster but not synchronized.");

        sc.close();
    }
}
