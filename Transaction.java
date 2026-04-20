public class Transaction {
    int id;
    String merchant;
    double amount;
    String category;
    String date;          

    //Class constructor (updated to include date)
    public Transaction(int id, String merchant, double amount, String category, String date){
        this.id = id;
        this.merchant = merchant;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    /** Display Transaction  (View All Transactions).
     @return Transaction  (View All Transactions) .

     */
    public void display(){
        System.out.printf("ID: %-10d | Merchant: %-15s  | Amount: %-10.2f  | Category: %-15s | Date: %s\n",
                          id, merchant, amount, category, date);
    }
}
