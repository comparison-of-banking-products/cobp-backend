package ru.cobp.backend.service.calculator.impl;

import org.springframework.stereotype.Service;
import ru.cobp.backend.dto.calculator.AnnuityCreditCalculatorDto;
import ru.cobp.backend.service.calculator.AnnuityCreditCalculator;

@Service
public class AnnuityCreditCalculatorImpl implements AnnuityCreditCalculator {

    @Override
    public AnnuityCreditCalculatorDto calculate(int amount, int term) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
