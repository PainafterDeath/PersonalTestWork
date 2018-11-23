import support.Dialoger;
import support.FileStorage;
import transactionBook.Transaction;
import transactionBook.TransactionBook;

/**
 * Main program which controls almost all other classes, input and outputs
 */
class Program {
    private Dialoger d;
    private TransactionBook tb;

    Program(Dialoger d) {
        this.d = d;
        tb = new TransactionBook();
    }

    void start() {
        while (true){
            printMenu();

            switch (d.read()){
                case "1":
                    readIncome();
                    break;
                case "2":
                    readOutcome();
                    break;
                case "3":
                    printTransactions();
                    break;
                case "4":
                    printBalance();
                    break;
                case "0":
                    if (FileStorage.save(tb.getTransactions())) return;
                    else d.print("Failure occurred during saving into file \"money.txt\". " +
                            "Close application knowing that not data is not saved!");
                    break;
                    default:
                        d.print("Wrong item no. Usable: [0:4].");
            }
            d.print("\n");
        }
    }

    /**
     * print current balance in TransactionBook
     */
    private void printBalance() {
        d.print("FINAL BALANCE: " + tb.getBalance());
    }

    private void printTransactions() {
        d.print("TRANSACTION LIST:");
        for (Transaction t : tb.getTransactions()){
            d.print(t + "");
        }
    }

    private void readIncome() {
        int amount = readAmount();
        if (amount < 1){
            d.print("Amount must be bigger than 0. Income not registered");
            return;
        }
        String description = readDescription();
        tb.registerIncome(amount, description);
    }

    private void readOutcome() {
        int amount = readAmount();
        if (amount < 1){
            d.print("Amount must be bigger than 0. Income not registered");
            return;
        }
        String description = readDescription();
        tb.registerOutcome(amount, description);
    }

    private String readDescription() {
        d.print("Enter description");
        return d.read();
    }

    private int readAmount() {
        d.print("Enter amount:");
        return Integer.parseInt(d.read());
    }

    private void printMenu() {
        d.print("1. Register income");
        d.print("2. Register outcome");
        d.print("3. print all transactions");
        d.print("4. Print balance");
        d.print("0. Save and quit");
    }
}
