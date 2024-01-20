package ru.cobp.backend.service.calculator;

import ru.cobp.backend.dto.calculator.CreditCalculatorParams;
import ru.cobp.backend.dto.calculator.DepositCalculatorParams;
import ru.cobp.backend.model.calculator.CalculatedCreditList;
import ru.cobp.backend.model.calculator.CalculatedDepositList;

public interface CalculatorService {

    CalculatedDepositList getAllMaximumRateCalculatedDepositList(DepositCalculatorParams params);

    CalculatedCreditList getAllMinimumRateCalculatedCreditList(CreditCalculatorParams params);

}
