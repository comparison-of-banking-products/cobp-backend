package ru.cobp.backend.service.calculator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.common.Constant;
import ru.cobp.backend.model.calculator.CreditCalculator;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.service.calculator.CreditCalculatorService;
import ru.cobp.backend.service.credit.CreditService;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CreditCalculatorServiceImpl implements CreditCalculatorService {

    private final CreditService creditService;

    @Override
    public CreditCalculator calculateMinimumRateAnnuityCredit(int amount, int term) {
        Credit credit = creditService.findMinimumRateCreditByAmountAndTerm(amount, term);
        double rate = credit.getRate();

        double monthlyRate = calculateMonthlyInterestRate(rate);
        double monthlyPayment = amount * monthlyRate / (1 - Math.pow(1 + monthlyRate, -term));
        double totalInterest = monthlyPayment * term - amount;
        double totalPayments = totalInterest + amount;

        return new CreditCalculator(credit.getId(), rate, monthlyPayment, totalInterest, totalPayments);
    }

    private double calculateMonthlyInterestRate(double annualRate) {
        return annualRate / (100.0 * Constant.NUMBER_OF_MONTHS_IN_YEAR);
    }

}