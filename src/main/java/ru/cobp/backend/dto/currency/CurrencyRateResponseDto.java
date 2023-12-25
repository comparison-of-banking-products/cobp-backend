package ru.cobp.backend.dto.currency;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Валютная котировка")
@Data
@NoArgsConstructor
public class CurrencyRateResponseDto {

    @Schema(description = "Базовая валюта")
    private String base;

    @Schema(description = "Название валюты")
    private String name;

    @Schema(description = "Валютный курс")
    private Double rate;

    @Schema(description = "Курсовая разница")
    private Double diff;

}
