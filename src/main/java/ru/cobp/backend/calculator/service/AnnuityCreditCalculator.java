package ru.cobp.backend.calculator.service;

import ru.cobp.backend.calculator.dto.AnnuityCreditCalculatorDto;

public interface AnnuityCreditCalculator extends CreditCalculator {

    AnnuityCreditCalculatorDto calculate(int amount, int term);

}
