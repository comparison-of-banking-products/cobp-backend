package ru.cobp.backend.calculator.service;

import ru.cobp.backend.calculator.dto.DifferentialCreditCalculatorDto;

public interface DifferentialCreditCalculator extends CreditCalculator {

    DifferentialCreditCalculatorDto calculate(int amount, int term);

}
