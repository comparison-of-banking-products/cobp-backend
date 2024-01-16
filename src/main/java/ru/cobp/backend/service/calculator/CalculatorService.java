package ru.cobp.backend.service.calculator;

import org.springframework.data.domain.Pageable;
import ru.cobp.backend.model.calculator.CalculatedCreditList;
import ru.cobp.backend.model.calculator.CalculatedDepositList;

import java.util.List;

public interface CalculatorService {

    CalculatedDepositList getAllMaximumRateCalculatedDeposits(
            int amount,
            int term,
            Boolean capitalization,
            Boolean replenishment,
            Boolean partialWithdrawal,
            List<String> bics,
            Pageable pageable
    );

    CalculatedCreditList getAllMinimumRateCalculatedCredits(
            int amount, int term, List<String> bics, Pageable pageable
    );

}
