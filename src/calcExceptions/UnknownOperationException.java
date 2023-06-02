package calcExceptions;

public class UnknownOperationException extends IllegalArgumentException {
    public UnknownOperationException(String message) {
        super(message);
    }
}
