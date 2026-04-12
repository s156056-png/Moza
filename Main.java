import java.util.*;

public class Main {

    static Scanner input = new Scanner(System.in);
    static Transaction[] transactions;
    static int size = 0;

    public static void main(String[] args) {

        int choice;

        do {
            //display PocketBank Admin Menu
            System.out.println("\n--- PocketBank Admin Menu ---");
            System.out.println("1. View All Transactions (Unsorted)");
            System.out.println("2. Sort by Amount: Smallest to Largest (Selection Sort)");
            System.out.println("3. Sort by ID: Numerical Order (Insertion Sort)");
            System.out.println("4. Search for Transaction by ID (Binary Search)");
            System.out.println("5. Filter: Find All Transactions in a Category (Linear Search)");
            System.out.println("6. Randomly generate data for new Transactions ");
            System.out.println("7. Exit Portal ");

            //read user choice
            System.out.print("Enter choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1: viewAll(); break;
                case 2: selectionSort(); break;
                case 3: insertionSort(); break;
                case 4: binarySearch(); break;
                case 5: filterCategory(); break;
                case 6: generateData(); break;
                case 7: System.out.println("Goodbye"); break;
                default:System.out.println("Invalid choice!");
            }

        } while (choice != 7);
    }

    /** Display Transaction  (View All Transactions) Call display method from Transactions class.
     @return Transaction  (View All Transactions) .
     */
    public static void viewAll() {
        //validate data size
        if (size == 0) {
            System.out.println("No data available!");
            return;
        }

        for (int i = 0; i < size; i++) {
            transactions[i].display();
        }
    }

    /** Sort an arry by Selection sort (linear sort) according to their amount.
     @return Sorted arry by amount.
     */
    public static void selectionSort() {
        if (size == 0) return;
        for (int i = 0; i < size - 1; i++) {
            int min = i;

            //check for minimum amount
            for (int j = i + 1; j < size; j++) {
                if (transactions[j].amount < transactions[min].amount) {
                    min = j;
                }
            }

            //swap
            Transaction temp = transactions[i];
            transactions[i] = transactions[min];
            transactions[min] = temp;
        }

        System.out.println("Sorted by Amount!");
    }

    /** Sort an arry by Insertion sort according to their ID.
     @return Sorted arry by ID.
     */
    public static void insertionSort() {}


    /** Search for Transaction by binary search according to their ID.
     @return Searched transaction.
     */
    public static void binarySearch() {}


    /** Filter Transactions by Linear search according to their Category.
     @return Filtered transaction.
     */
    public static void filterCategory() {}


    /** Randomly generate data for new Transactions (ask user to specify the data size).
     @return new Transactions generated randomly .
     */
    public static void generateData(){}


}
