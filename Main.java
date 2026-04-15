/**
Start

    Declare transactions array
    Declare size = 0
    Declare isSortedByID = false
    Declare current_id = 100000

    merchants = ["Starbucks", "Amazon", "Steam Games", "Whole Foods", "Shell Gas", "Netflix"]
    categories = ["Food", "Shopping", "Entertainment", "Groceries", "Transport", "Subscriptions"]

    Do
        Print "--- PocketBank Admin Menu ---"
        Print "1. View All Transactions"
        Print "2. Sort by Amount (Selection Sort)"
        Print "3. Sort by ID (Insertion Sort)"
        Print "4. Search by ID (Binary Search)"
        Print "5. Filter by Category"
        Print "6. Generate Random Transactions"
        Print "7. Exit"

        Print "Enter your choice: "
        Read choice

        If choice == 1 Then
            viewAll()

        Else If choice == 2 Then
            selectionSort()
            isSortedByID = false

        Else If choice == 3 Then
            insertionSort()
            isSortedByID = true

        Else If choice == 4 Then
            binarySearch()

        Else If choice == 5 Then
            filterCategory()

        Else If choice == 6 Then
            generateData()

        Else If choice == 7 Then
            Print "Goodbye"

        Else
            Print "Invalid choice!"
        End If

    While choice != 7

End


// Function viewAll
Function viewAll()
    If size == 0 Then
        Print "No data available!"
        Return
    End If

    For i = 0 to size-1
        Display transactions[i]
    End For
End Function


// Function selectionSort
Function selectionSort()
    If size == 0 Then
        Print "No data available!"
        Return
    End If

    For i = 0 to size-2
        min = i
        For j = i+1 to size-1
            If transactions[j].amount < transactions[min].amount Then
                min = j
            End If
        End For

        Swap transactions[i] with transactions[min]
    End For

    Print "Sorted by Amount!"
End Function


// Function insertionSort
Function insertionSort()
    If size == 0 Then
        Print "No data available!"
        Return
    End If

    For i = 1 to size-1
        temp = transactions[i]
        j = i

        While j > 0 and transactions[j-1].id > temp.id
            transactions[j] = transactions[j-1]
            j = j - 1
        End While

        transactions[j] = temp
    End For

    Print "Sorted by ID!"
End Function


// Function binarySearch
Function binarySearch()
    If size == 0 Then
        Print "No data available!"
        Return
    End If

    If isSortedByID == false Then
        Print "List must be sorted by ID first!"
        Print "Please run Option 3 first."
        Return
    End If

    Print "Enter Transaction ID: "
    Read target

    index = binarySearchHelper(target)

    If index != -1 Then
        Print "Transaction found:"
        Display transactions[index]
    Else
        Print "Transaction not found!"
    End If
End Function


// Function filterCategory
Function filterCategory()
    If size == 0 Then
        Print "No data available!"
        Return
    End If

    Print "Enter Category: "
    Read category

    found = false

    For i = 0 to size-1
        If category equalsIgnoreCase transactions[i].category Then
            Display transactions[i]
            found = true
        End If
    End For

    If found == false Then
        Print "Category not found!"
    End If
End Function


// Function generateData
Function generateData()
    Print "Enter number of transactions: "
    Read size

    Create transactions array with new size

    For i = 0 to size-1
        current_id = current_id + random(1 to 100)
        index = random(0 to 5)
        merchant = merchants[index]
        category = categories[index]
        amount = random(1.00 to 500.00)

        transactions[i] = new Transaction(current_id, merchant, amount, category)
    End For

    Print "Data created!"
End Function

End
**/



import java.util.*;

public class Main {

    static Scanner input = new Scanner(System.in);
    static Transaction[] transactions;
    static int size = 0;
    static Random rand = new Random();
    private static String[] merchants = {"Starbucks", "Amazon", "Steam Games", "Whole Foods", "Shell Gas", "Netflix"};
    private static String[] categories= {"Food", "Shopping", "Entertainment", "Groceries", "Transport", "Subscriptions"};
    static boolean isSortedByID = false;
    static int current_id = 100000;

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
                case 1:
                    viewAll();
                    break;
                case 2:
                    selectionSort();
                    isSortedByID = false;
                    break;
                case 3:
                    insertionSort();
                    isSortedByID = true;
                    break;
                case 4:
                    binarySearch();
                    break;
                case 5:
                    filterCategory();
                    break;
                case 6:
                    generateData();
                    break;
                case 7:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice!");
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
        if (size == 0){
            System.out.println("No data available!");
            return;
        }
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

    /** Sort an array by Insertion sort according to their ID.
     @return Sorted array by ID.
     */
    public static void insertionSort() {
        // if user does not enter data for transaction,ask him to enter data  first
        if (size == 0) {
            System.out.println("No data available!");
            return;
        }
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
    public static void binarySearch() {
        if (size == 0) {
            System.out.println("No data available!");
            return;
        }
        if (!isSortedByID) {
            System.out.println("List must be sorted by ID first!");
            System.out.println("Please run Option 3 first.");
            return;
        }

        System.out.print("Enter Transaction ID to search: ");
        int target = input.nextInt();

        int index = binarySearchHelper(transactions, size, target);

        if (index != -1) {
            System.out.println("Transaction found:");
            transactions[index].display();
        } else {
            System.out.println("Transaction with ID " + target + " not found.");
        }
    }

    // Helper for Binary Search
    private static int binarySearchHelper(Transaction[] arr, int n, int target) {
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



    /** Filter Transactions by Linear search according to their Category.
     @return Filtered transaction.
     */
    public static void filterCategory() {
        if (size == 0) {
            System.out.println("No data available!");
            return;
        }
        ArrayList<Transaction> result = new ArrayList<>();
        System.out.print("Enter Category: ");
        input.nextLine();
        String category = input.nextLine();
        for (int i = 0; i < size; i++) {
            if (category.equalsIgnoreCase(transactions[i].category)) {
                result.add(transactions[i]);
            }
        }
        if(result.isEmpty()){
            System.out.println("Category not found!");
        }else {
            //print category
            for (int i = 0; i < result.size(); i++) {
                result.get(i).display();
            }
        }
    }


    /** Randomly generate data for new Transactions (ask user to specify the data size).
     @return new Transactions generated randomly .
     */
    public static void generateData(){

        System.out.print("Enter number of transactions you want to create: ");
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
        System.out.println("Data created!");
    }


}
