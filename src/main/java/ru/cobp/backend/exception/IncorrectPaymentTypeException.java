package ru.cobp.backend.exception;

public class IncorrectPaymentTypeException extends RuntimeException {

    public IncorrectPaymentTypeException(String message) {
        super(message);
    }

}
