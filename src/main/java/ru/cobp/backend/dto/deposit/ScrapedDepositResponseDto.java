package ru.cobp.backend.dto.deposit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankResponseDto;
import ru.cobp.backend.dto.currency.CurrencyResponseDto;

@Schema(description = "Скрапленный вклад")
@Data
@NoArgsConstructor
public class ScrapedDepositResponseDto {

    @Schema(description = "Id")
    private Long id;

    @Schema(description = "Банк")
    private BankResponseDto bank;

    @Schema(description = "Название")
    private String name;

    @Schema(description = "URL-адрес продукта")
    private String productUrl;

    @Schema(description = "Доступность")
    private Boolean isActive;

    @Schema(description = "Валюта")
    private CurrencyResponseDto currency;

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
