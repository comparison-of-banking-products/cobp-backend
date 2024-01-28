package ru.cobp.backend.dto.deposit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.validation.constraints.Amount;
import ru.cobp.backend.validation.constraints.Rate;
import ru.cobp.backend.validation.constraints.Term;

@Schema(description = "Обновление вклада")
@Data
@NoArgsConstructor
public class DepositPatchRequestDto {

    @Schema(description = "Доступность")
    private Boolean isActive;

    @Schema(description = "Минимальная сумма")
    @Amount
    private Integer amountMin;

    @Schema(description = "Максимальная сумма")
    @Amount
    private Integer amountMax;

    @Schema(description = "Срок")
    @Term
    private Integer term;

    @Schema(description = "Процентная ставка")
    @Rate
    private Double rate;

    @Schema(description = "С капитализацией")
    private Boolean capitalization;

    @Schema(description = "С пополнением")
    private Boolean replenishment;

    @Schema(description = "С частичным снятием")
    private Boolean partialWithdrawal;

}
