package transactionBook;

import support.FileStorage;

import java.util.ArrayList;

/**
 * TransactionBook class is used to keep track of incoming/outgoing transactions and current balance
 * When class is created it will try to load from file "money.txt". If file not found or empty, empty list will be created and balance value 0.
 */
public class TransactionBook {
    private ArrayList<Transaction> transactions;
    private int balance;

    public TransactionBook(){
        transactions = FileStorage.load();
        balance = countBalance();
    }

    public void registerIncome(int amount, String describtion){
        transactions.add(new Transaction('+', amount, describtion));
        balance += amount;
    }

    public void registerOutcome(int amount, String describtion){
        transactions.add(new Transaction('-', amount, describtion));
        balance -= amount;
    }

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    public int getBalance() {
        return balance;
    }

    /**
     * Method used during construction of class.
     * When transactions are loaded from file, balance needs to be counted as it is stored locally.
     * @return
     */
    private int countBalance() {
        int bal = 0;
        for (Transaction t : transactions){
            if (t.getSign() == '-') bal -= t.getAmount();
            if (t.getSign() == '+') bal += t.getAmount();
        }
        return bal;
    }
}
