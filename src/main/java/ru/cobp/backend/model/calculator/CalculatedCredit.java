package ru.cobp.backend.model.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.cobp.backend.model.credit.Credit;

@Data
@AllArgsConstructor
public class CalculatedCredit {

    private Credit credit;

    private Double monthlyPayment;

    private Double totalPayments;

    private Double maturityInterest;

}
