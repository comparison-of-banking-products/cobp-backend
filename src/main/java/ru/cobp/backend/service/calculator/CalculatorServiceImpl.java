package ru.cobp.backend.service.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.common.Constants;
import ru.cobp.backend.model.calculator.CalculatedCredit;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
import ru.cobp.backend.model.calculator.CalculatedDepositList;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.model.deposit.DepositList;
import ru.cobp.backend.service.credit.CreditService;
import ru.cobp.backend.service.deposit.DepositService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private final DepositService depositService;

    private final CreditService creditService;

    @Override
    public CalculatedDepositList getAllMaximumRateCalculatedDeposits(
            int amount,
            int term,
            Boolean capitalization,
            Boolean replenishment,
            Boolean partialWithdrawal,
            List<String> bics,
            Pageable pageable
    ) {
        DepositList depositList = depositService.findAllMaximumRateDeposits(
                amount, term, capitalization, replenishment, partialWithdrawal, bics, pageable
        );
        List<CalculatedDeposit> calculatedDeposits = calculateDepositsInterest(depositList.getDeposits(), amount, term);

        return new CalculatedDepositList(calculatedDeposits, depositList.getTotalElements());
    }

    @Override
    public List<CalculatedCredit> getAllMinimumRateCalculatedCredits(
            int amount, int term, List<String> bics, Pageable pageable
    ) {
        List<Credit> credits = creditService.findAllMinimumRateCredits(amount, term, bics, pageable);
        return calculateCreditsPayments(credits, amount, term);
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

    private List<CalculatedCredit> calculateCreditsPayments(List<Credit> credits, int amount, int term) {
        return credits.stream()
                .map(c -> calculateCreditPayment(c, amount, term))
                .collect(Collectors.toList());
    }

    private CalculatedCredit calculateCreditPayment(Credit credit, int amount, int term) {
        double rate = credit.getRate();

        double monthlyRate = calculateMonthlyInterestRate(rate);
        double monthlyPayment = amount * monthlyRate / (1 - Math.pow(1 + monthlyRate, -term));
        double totalPayments = monthlyPayment * term;
        double maturityInterest = totalPayments - amount;

        return new CalculatedCredit(credit, monthlyPayment, totalPayments, maturityInterest);
    }

    private double calculateSimpleInterest(int amount, int termInMonths, double annualRate) {
        return (amount * ((double) termInMonths / Constants.NUMBER_OF_MONTHS_IN_YEAR) * annualRate) / 100;
    }

    private double calculateMonthlyInterestRate(double annualRate) {
        return annualRate / (100.0 * Constants.NUMBER_OF_MONTHS_IN_YEAR);
    }

}
