package ru.cobp.backend.dto.calculator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankShortResponseDto;
import ru.cobp.backend.dto.deposit.DepositShortResponseDto;

@Schema(description = "Результат расчета депозита")
@Data
@NoArgsConstructor
public class CalculatedDepositResponseDto {

    @Schema(description = "Банк")
    private BankShortResponseDto bank;

    @Schema(description = "Вклад")
    private DepositShortResponseDto deposit;

    @Schema(description = "Среднегодовой доход вклада")
    private Double annualInterest;

    @Schema(description = "Доход по истечению срока вклада")
    private Double maturityInterest;

    @Schema(description = "Общий размер вклада")
    private Double totalAmount;

}
