package ru.cobp.backend.dto.deposit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankShortResponseDto;

@Schema(description = "Вклад")
@Data
@NoArgsConstructor
public class DepositResponseDto {

    @Schema(description = "Банк")
    private BankShortResponseDto bank;

    @Schema(description = "Название вклада")
    private String depositName;

    @Schema(description = "Ссылка на вклад")
    private String depositUrl;

    @Schema(description = "Срок вклада")
    private Integer term;

    @Schema(description = "Процентная ставка вклада")
    private Double rate;

    @Schema(description = "Вклад с капитализацией")
    private Boolean capitalization;

    @Schema(description = "Вклад с пополнением")
    private Boolean replenishment;

    @Schema(description = "Вклад с частичным снятием")
    private Boolean partialWithdrawal;

}
