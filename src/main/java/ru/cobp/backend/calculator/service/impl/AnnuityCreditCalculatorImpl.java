package ru.cobp.backend.calculator.service.impl;

import org.springframework.stereotype.Service;
import ru.cobp.backend.calculator.dto.AnnuityCreditCalculatorDto;
import ru.cobp.backend.calculator.service.AnnuityCreditCalculator;

@Service
public class AnnuityCreditCalculatorImpl implements AnnuityCreditCalculator {

    @Override
    public AnnuityCreditCalculatorDto calculate(int amount, int term) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
