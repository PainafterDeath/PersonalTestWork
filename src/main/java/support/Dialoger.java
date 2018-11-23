package support;

/**
 * interface for different implementation for dialogs with user
 */
public interface Dialoger {
    void print(String message);
    String read();
}
