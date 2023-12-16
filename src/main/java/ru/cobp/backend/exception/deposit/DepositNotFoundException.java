package ru.cobp.backend.exception.deposit;

public class DepositNotFoundException extends RuntimeException {

    public DepositNotFoundException(String message) {
        super(message);
    }

}
