package ru.cobp.backend.service.calculator;

import ru.cobp.backend.model.calculator.CalculatedDeposit;

import java.util.List;

public interface DepositCalculatorService {

    CalculatedDeposit getMaximumRateCalculatedDeposit(int amount, int term);

    List<CalculatedDeposit> getCalculatedDeposits(int amount, int term, double rate);

}
