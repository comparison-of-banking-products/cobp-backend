package ru.cobp.backend.model.exchange;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ExchangeRates {

    private LocalDateTime timestamp;

    private String base;

    private Map<String, Double> quotes;

}
