package ru.cobp.backend.dto.deposit;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.validation.constraints.Amount;
import ru.cobp.backend.validation.constraints.Bic;
import ru.cobp.backend.validation.constraints.CurrencyNum;
import ru.cobp.backend.validation.constraints.DepositName;
import ru.cobp.backend.validation.constraints.Rate;
import ru.cobp.backend.validation.constraints.Term;
import ru.cobp.backend.validation.constraints.Url;

@Schema(description = "Новый вклад")
@Data
@NoArgsConstructor
public class DepositPostRequestDto {

    @Schema(description = "БИК банка")
    @NotNull(message = "{bic.notnull.invalid}")
    @Bic
    private String bic;

    @Schema(description = "Название вклада")
    @NotNull(message = "{deposit.name.notnull.invalid}")
    @DepositName
    private String name;

    @Schema(description = "URL-адрес вклада")
    @NotNull(message = "{url.notnull.invalid}")
    @Url
    private String productUrl;

    @Schema(description = "Доступность")
    @NotNull(message = "{deposit.active.notnull.invalid}")
    private Boolean isActive;

    @Schema(description = "Цифровой код валюты")
    @NotNull(message = "{currency.num.notnull.invalid}")
    @CurrencyNum
    private String currencyNum;

    @Schema(description = "Минимальная сумма")
    @NotNull(message = "{amount.notnull.invalid}")
    @Amount
    private Integer amountMin;

    @Schema(description = "Максимальная сумма")
    @NotNull(message = "{amount.notnull.invalid}")
    @Amount
    private Integer amountMax;

    @Schema(description = "Срок")
    @NotNull(message = "{term.notnull.invalid}")
    @Term
    private Integer term;

    @Schema(description = "Процентная ставка")
    @NotNull(message = "{rate.notnull.invalid}")
    @Rate
    private Double rate;

    @Schema(description = "С капитализацией")
    @NotNull(message = "{deposit.capitalization.notnull.invalid}")
    private Boolean capitalization;

    @Schema(description = "С пополнением")
    @NotNull(message = "{deposit.replenishment.notnull.invalid}")
    private Boolean replenishment;

    @Schema(description = "С частичным снятием")
    @NotNull(message = "{deposit.partialWithdrawal.notnull.invalid}")
    private Boolean partialWithdrawal;

}
