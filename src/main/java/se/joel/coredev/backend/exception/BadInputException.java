package se.joel.coredev.backend.exception;

public final class BadInputException extends RuntimeException {

    public BadInputException(String message) {
        super(message);
    }
}
