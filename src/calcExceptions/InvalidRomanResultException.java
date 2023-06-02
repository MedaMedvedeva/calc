package calcExceptions;

public class InvalidRomanResultException extends IllegalArgumentException {
    public InvalidRomanResultException(String message) {
        super(message);
    }
}
