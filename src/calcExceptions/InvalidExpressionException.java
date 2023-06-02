package calcExceptions;

public class InvalidExpressionException extends IllegalArgumentException {
    public InvalidExpressionException(String message) {
        super(message);
    }
}
