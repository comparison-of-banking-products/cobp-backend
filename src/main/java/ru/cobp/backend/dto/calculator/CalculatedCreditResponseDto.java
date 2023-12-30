package ru.cobp.backend.dto.calculator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.credit.CreditShortResponseDto;

@Schema(description = "Результат расчета кредита")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatedCreditResponseDto {

    @Schema(description = "Кредит")
    private CreditShortResponseDto credit;

    @Schema(description = "Ежемесячный платеж")
    private Double monthlyPayment;

    @Schema(description = "Общий размер платежа")
    private Double totalPayments;

    @Schema(description = "Начисленные проценты по истечению срока")
    private Double maturityInterest;

}
