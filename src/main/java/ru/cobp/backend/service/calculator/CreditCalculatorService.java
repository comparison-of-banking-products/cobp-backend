package ru.cobp.backend.service.calculator;

import org.springframework.data.domain.Pageable;
import ru.cobp.backend.model.calculator.CalculatedCredit;

import java.util.List;

public interface CreditCalculatorService {

    List<CalculatedCredit> getAllMinimumRateCalculatedCredits(int amount, int term, Pageable pageable);

}
