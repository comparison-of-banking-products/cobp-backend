package ru.cobp.backend.exception;

public class UnsupportedPaymentTypeException extends RuntimeException {

    public UnsupportedPaymentTypeException(String exception) {
        super(exception);
    }

}
