package ru.cobp.backend.service.deposit;

import org.springframework.data.domain.Page;
import ru.cobp.backend.dto.calculator.DepositCalculatorParams;
import ru.cobp.backend.dto.deposit.DepositParams;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.model.deposit.ScrapedDeposit;

import java.util.List;

public interface DepositService {

    Page<Deposit> getAllDepositPage(DepositParams depositParams);

    Page<Deposit> getAllMaximumRateDepositPage(DepositCalculatorParams params);

    List<ScrapedDeposit> getAllScrapedDeposits();

}
