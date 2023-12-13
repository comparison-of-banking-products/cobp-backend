package ru.cobp.backend.service.calculator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.model.calculator.DepositCalculator;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.service.calculator.DepositCalculatorService;
import ru.cobp.backend.service.deposit.DepositService;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DepositCalculatorServiceImpl implements DepositCalculatorService {

    private static final int NUMBER_OF_MONTHS_IN_YEAR = 12;

    private final DepositService depositService;

    @Override
    public DepositCalculator calculateMaximumRateDeposit(int amount, int term) {
        Deposit deposit = depositService.findMaximumRateDepositByAmountAndTerm(amount, term);
        double rate = deposit.getRate();
        double annualProfit = amount + calculateSimpleInterest(amount, 12, rate);
        double maturityProfit = amount + calculateSimpleInterest(amount, term, rate);

        return new DepositCalculator(deposit.getId(), rate, annualProfit, maturityProfit);
    }

    private double calculateSimpleInterest(int amount, int termInMonths, double annualRate) {
        return (amount * ((double) termInMonths / NUMBER_OF_MONTHS_IN_YEAR) * annualRate) / 100;
    }

}
