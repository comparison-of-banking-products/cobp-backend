package ru.cobp.backend.service.calculator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.common.Constants;
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
    public List<CalculatedDeposit> getAllMaximumRateCalculatedDeposits(
            int amount,
            int term,
            Boolean capitalization,
            Boolean replenishment,
            Boolean partialWithdrawal,
            Pageable pageable
    ) {
        List<Deposit> deposits = depositService.findAllMaximumRateDeposits(
                amount, term, capitalization, replenishment, partialWithdrawal, pageable
        );
        return calculateDepositsInterest(deposits, amount, term);
    }

    private List<CalculatedDeposit> calculateDepositsInterest(List<Deposit> deposits, int amount, int term) {
        return deposits.stream()
                .map(d -> calculateDepositInterest(d, amount, term))
                .collect(Collectors.toList());
    }

    private CalculatedDeposit calculateDepositInterest(Deposit deposit, int amount, int term) {
        double rate = deposit.getRate();

        double annualInterest = calculateSimpleInterest(amount, Constants.NUMBER_OF_MONTHS_IN_YEAR, rate);
        double maturityInterest = calculateSimpleInterest(amount, term, rate);
        double totalAmount = amount + maturityInterest;

        return new CalculatedDeposit(deposit, annualInterest, maturityInterest, totalAmount);
    }

    private double calculateSimpleInterest(int amount, int termInMonths, double annualRate) {
        return (amount * ((double) termInMonths / Constants.NUMBER_OF_MONTHS_IN_YEAR) * annualRate) / 100;
    }

}
