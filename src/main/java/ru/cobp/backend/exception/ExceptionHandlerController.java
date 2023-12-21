package ru.cobp.backend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public ExceptionHandlerResponseDto handle(ExchangeRatesProcessingFailedException e) {
        log.error("", e);
        return new ExceptionHandlerResponseDto(LocalDateTime.now(), e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionHandlerResponseDto handle(LogoFileNotFoundException e) {
        log.error("", e);
        return new ExceptionHandlerResponseDto(LocalDateTime.now(), e.getMessage());
    }

}
