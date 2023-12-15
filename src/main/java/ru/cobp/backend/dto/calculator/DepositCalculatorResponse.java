package ru.cobp.backend.dto.calculator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Результат расчета депозита")
@Data
@NoArgsConstructor
public class DepositCalculatorResponse {

    @Schema(description = "ID депозита ставка которого использовалась в расчетах")
    private Long depositId;

    @Schema(description = "Наивысшая доступная ставка")
    private Double rate;

    @Schema(description = "Среднегодовой доход")
    private Double annualProfit;

    @Schema(description = "Доход по истечению срока размещения")
    private Double maturityProfit;

}
