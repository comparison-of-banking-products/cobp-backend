package ru.cobp.backend.dto.currency;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Валюта")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyResponseDto {

    @Schema(description = "Цифровой код")
    private Long num;

    @Schema(description = "Символьный код")
    private String code;

    @Schema(description = "Название")
    private String currency;

}
