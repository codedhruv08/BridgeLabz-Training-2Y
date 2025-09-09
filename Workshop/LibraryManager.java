import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter book title: ");
        String bookTitle = sc.nextLine();

        System.out.print("Enter author name: ");
        String authorName = sc.nextLine();
        System.out.print("Enter another author name: ");
        String Another_authorName = sc.nextLine();
        

        System.out.print("Enter book ID: ");
        String bookId = sc.nextLine().toUpperCase();

        System.out.print("Is the book available? (true/false): ");
        boolean isAvailable = sc.nextBoolean();

        System.out.println("\nBook Information:");
        System.out.println("Title: " + bookTitle);
        System.out.println("Author: " + authorName);
        System.out.println("Book ID: " + bookId);
        System.out.println("Available: " + isAvailable);
        
        System.out.println(bookTitle.toUpperCase());
        System.out.println(authorName.length());
         if(authorName.equalsIgnoreCase(Another_authorName)){
            System.out.println("Authon name is same");
        }
        else{
            System.out.println("Authon name is not same");
        }
        System.out.println();
        System.out.println("RATINGS");

        System.out.print("How many ratings has the book received? ");

        int ratingCount = sc.nextInt();
        int[] bookRatings = new int[ratingCount];
        int sum = 0;

        for (int i = 0; i < ratingCount; i++) {
            System.out.print("Enter rating " + (i + 1) + " (1 to 5): ");
            bookRatings[i] = sc.nextInt();
            sum  += bookRatings[i];
        }
        double average = (double)sum/ratingCount;
         System.out.print("Ratings: ");
        for (int rating : bookRatings) {
            System.out.print(rating + " ");
            }
        if(ratingCount==0){
            System.out.println("No rating avilable");
            return;
        }
        for (int rating : bookRatings) {
            if (rating == 1) {
                System.out.print(rating+" ");
                System.out.println("\nOne user gave a poor rating!");
                continue;
            }
        }
        System.out.print("Average: ");
        System.out.println(average);
        System.out.println();
        if(average>=4){
            System.out.println("Highly rated book");
        }
        else{
            System.out.println("average book");
        }


    }

    


}
