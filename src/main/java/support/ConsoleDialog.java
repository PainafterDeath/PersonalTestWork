package support;

import java.util.Scanner;

/**
 * This class is for printing messages to console and/or reading from console (keyboard)
 */
public class ConsoleDialog implements Dialoger {
    private Scanner s;

    public ConsoleDialog() {
        s = new Scanner(System.in);
    }

    public void print(String message) {
        System.out.println(message);
    }

    /**
     * read full line
     * @return String line
     */
    public String read() {
        return s.nextLine();
    }
}
