public class Transaction {
    int id;
    String merchant;
    double amount;
    String category;

    //Class constructor

    public Transaction(int id, String merchant, double amount,String category){
        this.id = id;
        this.merchant = merchant;
        this.amount = amount;
        this.category = category;
    }

    /** Display Transaction  (View All Transactions).
     @return Transaction  (View All Transactions) .

     */

    public void display(){
        System.out.print("ID: " + id + " | Merchant: " + merchant + " | Amount: "+ amount + " | Category: " + category);
    }
}
