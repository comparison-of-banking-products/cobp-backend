package ru.cobp.backend.calculator.service.impl;

import org.springframework.stereotype.Service;
import ru.cobp.backend.calculator.dto.DifferentialCreditCalculatorDto;
import ru.cobp.backend.calculator.service.DifferentialCreditCalculator;

@Service
public class DifferentialCreditCalculatorImpl implements DifferentialCreditCalculator {

    @Override
    public DifferentialCreditCalculatorDto calculate(int amount, int term) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
