package support;

import transactionBook.Transaction;
import java.io.*;
import java.util.ArrayList;

/**
 * this class is only for saving/loading transaction list into/from file "money.txt".
 */
public class FileStorage {
    private static final String FILE_NAME = "money.txt";

    /**
     * Saves given transactions into file.
     * @param ArrayList<Transaction> transactions
     * @return boolean : true - save successful, false - save unsuccessful
     */
    public static boolean save(ArrayList<Transaction> transactions){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
            for (Transaction t: transactions){
                bw.write(t.getSign() +">"+ t.getAmount() +">"+ t.getDescription()+ "\n");
            }
            bw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static ArrayList<Transaction> load(){
        ArrayList<Transaction> ts = new ArrayList<Transaction>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String l;
            while ((l=br.readLine())!=null && !l.equals("")){
                String[] items = l.split(">", 3);
                if (items.length == 3) {
                    ts.add(new Transaction(items[0].charAt(0), Integer.parseInt(items[1]), items[2]));
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            new ConsoleDialog().print("File \"money.txt\" not found. Empty transaction list loaded");
        } catch (IOException e) {
            new ConsoleDialog().print("Read from file error. Check if everything is correct and report to software administrator");
        }
        return ts;
    }
}
