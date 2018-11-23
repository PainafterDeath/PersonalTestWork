import support.ConsoleDialog;

/**
 * clas holding psvm and calling our main program
 */
public class Main {
    /**
     * calls main program
     * @param args - not used but left as a standard
     */
    public static void main(String[] args) {
        new Program(new ConsoleDialog()).start();
    }
}
