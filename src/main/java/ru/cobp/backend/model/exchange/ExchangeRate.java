package ru.cobp.backend.model.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExchangeRate {

    private LocalDateTime actualDate;

    private String baseCode;

    private String quoteCode;

    private Double actualRate;

    private Double previousRate;

    private LocalDateTime previousDate;

}
