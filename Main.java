import java.util.*;

public class Main {

    static Scanner input = new Scanner(System.in);
    static Transaction[] transactions;
    static int size = 0;
    static Random rand = new Random();
    private static String[] merchants = {"Starbucks", "Amazon", "Steam Games", "Whole Foods", "Shell Gas", "Netflix"};
    private static String[] categories= {"Food", "Shopping", "Entertainment", "Groceries", "Transport", "Subscriptions"};

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
    public static void insertionSort() {
         // if user does not enter data for transaction,ask him to enter data  first
        if (size == 0) {
            System.out.println("No data available!");
            return;
        };
        int i,j;
        Transaction temp;
        for (i = 1; i < size ; i++) {
            temp = transactions[i];
            j=i;
            while ((j > 0 )&& (transactions[j-1].id > temp.id)) {
                transactions[j] = transactions[j-1];
                j--;
            }//while
            transactions[j] = temp;
        }//for
        System.out.println("Sorted by ID!");
    }


    /** Search for Transaction by binary search according to their ID.
     @return Searched transaction.
     */
    public static void binarySearch(Transaction[] arr, int n, int target) {
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].id == target) {
                return mid;
            } else if (arr[mid].id < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    }


    /** Filter Transactions by Linear search according to their Category.
     @return Filtered transaction.
     */
    public static void filterCategory() {}


    /** Randomly generate data for new Transactions (ask user to specify the data size).
     @return new Transactions generated randomly .
     */
    public static void generateData(){
        int current_id = 100000;
        System.out.println("Enter number of transactions you want to create: ");
        size = input.nextInt();//user enter the size of transaction array
        transactions = new Transaction[size];//define transaction array with size user entered
        for (int i = 0; i < size; i++) {
            // create small random number
            current_id+= rand.nextInt(100)+1;// add number between 1 and 100 to ensure it is unique
            // generate random index to pick merchant and category
            int index =rand.nextInt(merchants.length);
            String merchant = merchants[index];
            String category = categories[index];
            double amount = (rand.nextInt(50000) + 100) / 100.0 ;//generate random integer between 100 and 50000 and divide it by 100.00 to get two decimal places
            transactions[i] = new Transaction(current_id,merchant,amount,category);
        }
    }


}
