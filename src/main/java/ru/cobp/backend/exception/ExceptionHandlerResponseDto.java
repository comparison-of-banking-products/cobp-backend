package ru.cobp.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionHandlerResponseDto {

    private LocalDateTime timestamp;

    private String message;

}
