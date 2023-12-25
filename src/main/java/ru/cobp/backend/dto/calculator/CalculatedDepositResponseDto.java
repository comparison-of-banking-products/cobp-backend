package ru.cobp.backend.dto.calculator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.deposit.DepositResponseDto;

@Schema(description = "Результат расчета вклада")
@Data
@NoArgsConstructor
public class CalculatedDepositResponseDto {

    @Schema(description = "Вклад")
    private DepositResponseDto deposit;

    @Schema(description = "Среднегодовой доход вклада")
    private Double annualInterest;

    @Schema(description = "Доход по истечению срока вклада")
    private Double maturityInterest;

    @Schema(description = "Общий размер вклада")
    private Double totalAmount;

}
