package ru.cobp.backend.exception.storage;

public class LogoFileNotFoundException extends RuntimeException {

    public LogoFileNotFoundException(String message) {
        super(message);
    }

}
