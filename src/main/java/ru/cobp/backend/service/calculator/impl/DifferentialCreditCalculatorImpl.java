package ru.cobp.backend.service.calculator.impl;

import org.springframework.stereotype.Service;
import ru.cobp.backend.dto.calculator.DifferentialCreditCalculatorDto;
import ru.cobp.backend.service.calculator.DifferentialCreditCalculator;

@Service
public class DifferentialCreditCalculatorImpl implements DifferentialCreditCalculator {

    @Override
    public DifferentialCreditCalculatorDto calculate(int amount, int term) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
