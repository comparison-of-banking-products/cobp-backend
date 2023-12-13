package ru.cobp.backend.service.calculator;

import ru.cobp.backend.service.calculator.impl.DepositCalculator;

public interface DepositCalculatorService {

    DepositCalculator calculateMaximumRateDeposit(int amount, int term);

}
