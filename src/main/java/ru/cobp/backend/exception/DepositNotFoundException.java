package ru.cobp.backend.exception;

public class DepositNotFoundException extends RuntimeException {

    public DepositNotFoundException(String message) {
        super(message);
    }

}
