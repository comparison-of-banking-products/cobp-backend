package ru.cobp.backend.service.calculator;

import ru.cobp.backend.model.calculator.CreditCalculator;

public interface CreditCalculatorService {

    CreditCalculator calculateMinimumRateAnnuityCredit(int amount, int term);

}
