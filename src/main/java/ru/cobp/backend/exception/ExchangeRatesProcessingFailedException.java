package ru.cobp.backend.exception;

public class ExchangeRatesProcessingFailedException extends RuntimeException {

    public ExchangeRatesProcessingFailedException(String message, Throwable cause) {
        super(message, cause);
    }

}
