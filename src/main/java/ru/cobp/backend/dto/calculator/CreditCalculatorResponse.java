package ru.cobp.backend.dto.calculator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Результат расчета кредита")
@Data
@NoArgsConstructor
public class CreditCalculatorResponse {

    @Schema(description = "ID кредита ставка которого использовалась в расчетах")
    private Long creditId;

    @Schema(description = "Наинизшая доступная ставка")
    private Double rate;

    @Schema(description = "Ежемесячный платеж")
    private Double monthlyPayment;

    @Schema(description = "Начисленные проценты")
    private Double totalInterest;

    @Schema(description = "Общая выплата")
    private Double totalPayments;

}
