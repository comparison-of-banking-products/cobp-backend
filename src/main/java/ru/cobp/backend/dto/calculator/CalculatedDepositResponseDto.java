package ru.cobp.backend.dto.calculator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.deposit.DepositShortResponseDto;

@Schema(description = "Результат расчета вклада")
@Data
@NoArgsConstructor
public class CalculatedDepositResponseDto {

    @Schema(description = "Вклад")
    private DepositShortResponseDto deposit;

    @Schema(description = "Среднегодовой доход")
    private Double annualInterest;

    @Schema(description = "Доход по истечению срока")
    private Double maturityInterest;

    @Schema(description = "Общая сумма")
    private Double totalAmount;

}
