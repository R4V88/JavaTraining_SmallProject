package exception;

public class ProductCountNegativeException extends Exception {
    public ProductCountNegativeException(String message) {
        super(message);
    }

    public ProductCountNegativeException() {
        super();
    }
}
