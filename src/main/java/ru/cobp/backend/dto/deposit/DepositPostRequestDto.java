package ru.cobp.backend.dto.deposit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.validation.constraints.*;

@Schema(description = "Новый вклад")
@Data
@NoArgsConstructor
public class DepositPostRequestDto {

    @Schema(description = "БИК банка")
    @BicNotBlank
    private String bic;

    @Schema(description = "Название вклада")
    @DepositNameNotBlank
    private String name;

    @Schema(description = "URL-адрес вклада")
    @UrlNotBlank
    private String productUrl;

    @Schema(description = "Доступность")
    @DepositIsActiveNotNull
    private Boolean isActive;

    @Schema(description = "Цифровой код валюты")
    @CurrencyNumNotBlank
    private String currencyNum;

    @Schema(description = "Минимальная сумма")
    @AmountNotNull
    private Integer amountMin;

    @Schema(description = "Максимальная сумма")
    @AmountNotNull
    private Integer amountMax;

    @Schema(description = "Срок")
    @TermNotNull
    private Integer term;

    @Schema(description = "Процентная ставка")
    @RateNotNull
    private Double rate;

    @Schema(description = "С капитализацией")
    @DepositCapitalizationNotNull
    private Boolean capitalization;

    @Schema(description = "С пополнением")
    @DepositReplenishmentNotNull
    private Boolean replenishment;

    @Schema(description = "С частичным снятием")
    @DepositPartialWithdrawalNotNull
    private Boolean partialWithdrawal;

}
