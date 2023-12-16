package ru.cobp.backend.service.calculator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.common.Constant;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.service.calculator.DepositCalculatorService;
import ru.cobp.backend.service.deposit.DepositService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DepositCalculatorServiceImpl implements DepositCalculatorService {

    private final DepositService depositService;

    @Override
    public CalculatedDeposit getMaximumRateCalculatedDeposit(int amount, int term) {
        Deposit deposit = depositService.findMaximumRateDeposit(amount, term);
        return getCalculatedDeposit(amount, term, deposit);
    }

    @Override
    public List<CalculatedDeposit> getCalculatedDeposits(int amount, int term, double rate) {
        List<Deposit> deposits = depositService.findDeposits(amount, term, rate);
        return getCalculatedDeposits(amount, term, deposits);
    }

    private List<CalculatedDeposit> getCalculatedDeposits(int amount, int term, List<Deposit> deposits) {
        return deposits.stream()
                .map(d -> getCalculatedDeposit(amount, term, d))
                .collect(Collectors.toList());
    }

    private CalculatedDeposit getCalculatedDeposit(int amount, int term, Deposit deposit) {
        double rate = deposit.getRate();
        double annualInterest = calculateSimpleInterest(amount, Constant.NUMBER_OF_MONTHS_IN_YEAR, rate);
        double maturityInterest = calculateSimpleInterest(amount, term, rate);
        double totalAmount = amount + maturityInterest;

        return new CalculatedDeposit(deposit.getBank(), deposit, annualInterest, maturityInterest, totalAmount);
    }

    private double calculateSimpleInterest(int amount, int termInMonths, double annualRate) {
        return (amount * ((double) termInMonths / Constant.NUMBER_OF_MONTHS_IN_YEAR) * annualRate) / 100;
    }

}
