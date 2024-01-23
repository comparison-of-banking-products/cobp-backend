package ru.cobp.backend.service.calculator;

import ru.cobp.backend.dto.calculator.MinimumRateCreditParams;
import ru.cobp.backend.dto.calculator.MaximumRateDepositParams;
import ru.cobp.backend.model.calculator.CalculatedCreditList;
import ru.cobp.backend.model.calculator.CalculatedDepositList;

public interface CalculatorService {

    CalculatedDepositList getAllMaximumRateCalculatedDepositList(MaximumRateDepositParams params);

    CalculatedCreditList getAllMinimumRateCalculatedCreditList(MinimumRateCreditParams params);

}
