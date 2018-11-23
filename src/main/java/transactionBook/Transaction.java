package transactionBook;

/**
 * Transaction class defines on transaction (either income or outcome)
 * For deciding if it is income or outcome, sign variable is used
 */
public class Transaction {
    private char sign;
    private int amount;
    private String description;

    public Transaction(char sign, int amount, String description) {
        if (sign != '-' && sign != '+') throw new IllegalArgumentException();
        if (amount < 1) throw new IllegalArgumentException();
        this.sign = sign;
        this.amount = amount;
        this.description = description;
    }

    /**
     * retrieves sign indicating if transaction is income or outcome
     * @return char sign
     */
    public char getSign() {
        return sign;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return  sign +""+ amount +
                " " + description;
    }
}
