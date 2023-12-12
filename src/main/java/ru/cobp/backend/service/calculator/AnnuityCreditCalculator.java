package ru.cobp.backend.service.calculator;

import ru.cobp.backend.dto.calculator.AnnuityCreditCalculatorDto;

public interface AnnuityCreditCalculator extends CreditCalculator {

    AnnuityCreditCalculatorDto calculate(int amount, int term);

}
