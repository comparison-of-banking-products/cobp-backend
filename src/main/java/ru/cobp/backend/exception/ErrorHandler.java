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
        String[] errors = e.getStackTrace().toString().split("/");
        String reason = "The required object was not found.";
        String status = "NOT_FOUND";
        LocalDateTime timestamp = LocalDateTime.now();
        ApiError errorResponse = new ApiError(errors, message, reason, status, timestamp);
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

}
