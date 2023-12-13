package ru.cobp.backend.service.calculator;

import ru.cobp.backend.model.calculator.DepositCalculator;

public interface DepositCalculatorService {

    DepositCalculator calculateMaximumRateDeposit(int amount, int term);

}
