package ru.cobp.backend.dto.exchange;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Jacksonized
public class ExchangeRatesResponseDto {

    private String disclaimer;

    private String date;

    @JsonDeserialize(using = CustomTimestampDeserializer.class)
    private LocalDateTime timestamp;

    private String base;

    private Map<String, Double> rates;

}
