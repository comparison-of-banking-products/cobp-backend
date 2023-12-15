package ru.cobp.backend.model.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreditCalculator {

    private Long creditId;

    private Double rate;

    private Double monthlyPayment;

    private Double totalInterest;

    private Double totalPayments;

}
