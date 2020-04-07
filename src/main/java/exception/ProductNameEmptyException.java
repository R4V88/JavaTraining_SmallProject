package exception;

public class ProductNameEmptyException extends Exception {
    public ProductNameEmptyException(String message) {
        super(message);
    }

    public ProductNameEmptyException() {
        super();
    }
}
