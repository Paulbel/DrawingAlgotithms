package drawing;

public class NoPixelFoundException extends Exception {
    public NoPixelFoundException() {
        super();
    }

    public NoPixelFoundException(String message) {
        super(message);
    }

    public NoPixelFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPixelFoundException(Throwable cause) {
        super(cause);
    }
}
