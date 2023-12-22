package ru.cobp.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ApiError> handle(final NotFoundException e) {
        String message = e.getMessage();
        String reason = "The required object was not found.";
        String status = "NOT_FOUND";
        LocalDateTime timestamp = LocalDateTime.now();
        ApiError errorResponse = new ApiError(message, reason, status, timestamp);
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handle(final IncorrectPaymentTypeException e) {
        String message = e.getMessage();
        String reason = "Incorrect payment type";
        String status = "BAD_REQUEST";
        LocalDateTime timestamp = LocalDateTime.now();
        ApiError errorResponse = new ApiError(message, reason, status, timestamp);
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

}
