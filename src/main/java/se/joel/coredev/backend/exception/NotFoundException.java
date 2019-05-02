package se.joel.coredev.backend.exception;

public final class NotFoundException extends RuntimeException {
    public NotFoundException(String message){
        super(message);
    }
}
