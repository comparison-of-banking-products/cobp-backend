package ru.cobp.backend.service.calculator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.common.Constants;
import ru.cobp.backend.model.calculator.CalculatedCredit;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.service.calculator.CreditCalculatorService;
import ru.cobp.backend.service.credit.CreditService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CreditCalculatorServiceImpl implements CreditCalculatorService {

    private final CreditService creditService;

    @Override
    public List<CalculatedCredit> getAllMinimumRateCalculatedCredits(int amount, int term, Pageable pageable) {
        List<Credit> credits = creditService.findAllMinimumRateCredits(amount, term, pageable);
        return calculateCreditsPayments(credits, amount, term);
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

    private double calculateMonthlyInterestRate(double annualRate) {
        return annualRate / (100.0 * Constants.NUMBER_OF_MONTHS_IN_YEAR);
    }

}
