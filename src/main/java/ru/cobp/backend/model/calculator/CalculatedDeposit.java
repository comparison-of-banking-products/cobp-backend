package ru.cobp.backend.model.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.cobp.backend.model.deposit.Deposit;

@Data
@AllArgsConstructor
public class CalculatedDeposit {

    private Deposit deposit;

    private Double annualInterest;

    private Double maturityInterest;

    private Double totalAmount;

}
