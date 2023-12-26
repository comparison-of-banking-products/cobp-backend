package ru.cobp.backend.exception;

public class LogoFileNotFoundException extends RuntimeException {

    public LogoFileNotFoundException(String message) {
        super(message);
    }

    public LogoFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
