package ru.cobp.backend.dto.deposit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Новый вклад")
@Data
@NoArgsConstructor
public class DepositPostRequestDto {

    @Schema(description = "БИК банка")
    private String bic;

    @Schema(description = "Название вклада")
    private String name;

    @Schema(description = "URL-адрес вклада")
    private String productUrl;

    @Schema(description = "Доступность")
    private Boolean isActive;

    @Schema(description = "Цифровой код валюты")
    private Long currencyNum;

    @Schema(description = "Минимальная сумма")
    private Integer amountMin;

    @Schema(description = "Максимальная сумма")
    private Integer amountMax;

    @Schema(description = "Срок")
    private Integer term;

    @Schema(description = "Процентная ставка")
    private Double rate;

    @Schema(description = "С капитализацией")
    private Boolean capitalization;

    @Schema(description = "С пополнением")
    private Boolean replenishment;

    @Schema(description = "С частичным снятием")
    private Boolean partialWithdrawal;

}
