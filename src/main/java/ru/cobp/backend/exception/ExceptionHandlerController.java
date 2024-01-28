package ru.cobp.backend.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    private static final String VIOLATIONS_DELIMITER = ", ";

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDto handle(ExchangeRatesProcessingFailedException ex) {
        log.error(ex.getMessage(), ex);
        return new ErrorResponseDto(LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDto handle(LogoFileNotFoundException ex) {
        log.error(ex.getMessage(), ex);
        return new ErrorResponseDto(LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponseDto> handle(final NotFoundException ex) {
        log.error(ex.getMessage(), ex);
        String reason = "The required object was not found.";
        LocalDateTime timestamp = LocalDateTime.now();
        ErrorResponseDto errorResponse = new ErrorResponseDto(timestamp, reason);
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponseDto handle(final DuplicateException ex) {
        log.error(ex.getMessage(), ex);
        return new ErrorResponseDto(LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handle(ConstraintViolationException ex) {
        log.error(ex.getMessage(), ex);
        String messages = buildConstraintViolationMessages(ex.getConstraintViolations());
        return new ErrorResponseDto(LocalDateTime.now(), messages);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handle(MethodArgumentNotValidException ex) {
        log.error(ex.getMessage(), ex);
        String messages = buildAllErrorsMessages(ex.getBindingResult());
        return new ErrorResponseDto(LocalDateTime.now(), messages);
    }

    private String buildConstraintViolationMessages(Set<ConstraintViolation<?>> violations) {
        return violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(VIOLATIONS_DELIMITER));
    }

    private String buildAllErrorsMessages(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(VIOLATIONS_DELIMITER));
    }

}
