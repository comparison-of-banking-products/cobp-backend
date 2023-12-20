package ru.cobp.backend.model.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExchangeRate {

    private LocalDateTime dateTime;

    private String base;

    private String quote;

    private Double rate;

}
