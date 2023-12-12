package ru.cobp.backend.service.calculator;

import ru.cobp.backend.dto.calculator.DifferentialCreditCalculatorDto;

public interface DifferentialCreditCalculator extends CreditCalculator {

    DifferentialCreditCalculatorDto calculate(int amount, int term);

}
