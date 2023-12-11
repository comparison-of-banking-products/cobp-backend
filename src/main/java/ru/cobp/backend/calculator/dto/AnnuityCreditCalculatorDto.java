package ru.cobp.backend.calculator.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Результат расчета аннуитетного кредита")
@Data
@NoArgsConstructor
public class AnnuityCreditCalculatorDto {

    @Schema(description = "Наинизшая доступная ставка")
    private Double rate;

    @Schema(description = "Ежемесячный платеж")
    private Double monthlyPayment;

    @Schema(description = "Начисленные проценты")
    private Double totalInterest;

    @Schema(description = "Общая выплата")
    private Double totalPayments;

    @Schema(description = "Id кредита ставка которого использовалась в расчетах")
    private Long creditId;

}
