package transactionBook;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransactionBookTest {

    @Test
    public void registerIncome() {
        TransactionBook tb = new TransactionBook();
        int currentBalance = tb.getBalance();
        int currentTcount  = tb.getTransactions().size();

        tb.registerIncome(100, "retrieved loan");

        assertEquals(currentBalance + 100, tb.getBalance());
        assertEquals(currentTcount + 1, tb.getTransactions().size());
    }

    @Test
    public void registerOutcome() {
        TransactionBook tb = new TransactionBook();
        int currentBalance = tb.getBalance();
        int currentTcount  = tb.getTransactions().size();

        tb.registerOutcome(100, "given loan to friend");

        assertEquals(currentBalance - 100, tb.getBalance());
        assertEquals(currentTcount + 1, tb.getTransactions().size());
    }

    @Test
    public void getTransactions() {
        TransactionBook tb = new TransactionBook();
        int currentTcount  = tb.getTransactions().size();
        tb.registerOutcome(200, "rent payed");
        tb.registerIncome(100 ,"rent payed");
        tb.registerOutcome(200, "rent payed");
        tb.registerIncome(100, "retrieved loan");

        assertEquals(currentTcount + 4, tb.getTransactions().size());
    }

    @Test
    public void getBalance() {
        TransactionBook tb = new TransactionBook();
        int currentBalance = tb.getBalance();

        tb.registerOutcome(100, "given loan to friend");

        assertEquals(currentBalance - 100, tb.getBalance());
    }
}