package ru.cobp.backend.service.calculator;

import org.springframework.data.domain.Pageable;
import ru.cobp.backend.model.calculator.CalculatedDeposit;

import java.util.List;

public interface DepositCalculatorService {

    List<CalculatedDeposit> getAllMaximumRateCalculatedDeposits(int amount, int term, Pageable page);

}
