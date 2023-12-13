package ru.cobp.backend.service.calculator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.service.calculator.DepositCalculatorService;
import ru.cobp.backend.service.deposit.DepositService;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DepositCalculatorServiceImpl implements DepositCalculatorService {

    private final DepositService depositService;

    @Override
    public DepositCalculator calculateMaximumRateDeposit(int amount, int term) {
        Deposit deposit = depositService.findMaximumRateDepositByAmountAndTerm(amount, term);
        Double rate = deposit.getRate();
        double annualProfit = amount + calculateSimpleInterest(amount, 12, rate);
        double maturityProfit = amount + calculateSimpleInterest(amount, term, rate);

        return new DepositCalculator(deposit.getId(), rate, annualProfit, maturityProfit);
    }

    private double calculateSimpleInterest(int amount, int term, double rate) {
        return (amount * (term / 12.0) * rate) / 100;
    }

}
