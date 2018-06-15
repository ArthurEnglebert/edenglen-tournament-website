package be.edenglen.tournament.ws.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        // OK
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
