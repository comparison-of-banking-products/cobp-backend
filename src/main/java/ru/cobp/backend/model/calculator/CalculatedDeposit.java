package ru.cobp.backend.model.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.deposit.Deposit;

@Data
@AllArgsConstructor
public class CalculatedDeposit {

    private Bank bank;

    private Deposit deposit;

    private Double annualInterest;

    private Double maturityInterest;

    private Double totalAmount;

}
