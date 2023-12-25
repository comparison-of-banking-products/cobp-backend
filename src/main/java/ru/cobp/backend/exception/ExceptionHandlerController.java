package ru.cobp.backend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.cobp.backend.exception.exchange.ExchangeRatesProcessingFailedException;
import ru.cobp.backend.exception.storage.LogoFileNotFoundException;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionHandlerResponseDto handle(ExchangeRatesProcessingFailedException ex) {
        log.error(ex.getMessage(), ex);
        return new ExceptionHandlerResponseDto(LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionHandlerResponseDto handle(LogoFileNotFoundException ex) {
        log.error(ex.getMessage(), ex);
        return new ExceptionHandlerResponseDto(LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExceptionHandlerResponseDto> handle(final NotFoundException e) {
        log.error("", e);
        String reason = "The required object was not found.";
        LocalDateTime timestamp = LocalDateTime.now();
        ExceptionHandlerResponseDto errorResponse = new ExceptionHandlerResponseDto(timestamp, reason);
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(errorResponse, httpStatus);
    }

}
