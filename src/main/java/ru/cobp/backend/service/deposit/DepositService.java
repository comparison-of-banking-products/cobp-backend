package ru.cobp.backend.service.deposit;

import org.springframework.data.domain.Page;
import ru.cobp.backend.dto.calculator.MaximumRateDepositParams;
import ru.cobp.backend.dto.deposit.DepositParams;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.model.deposit.DepositPatch;
import ru.cobp.backend.model.deposit.ScrapedDeposit;

import java.util.List;

public interface DepositService {

    Deposit save(Deposit deposit);

    Deposit update(long id, DepositPatch patch);

    Deposit getById(long id);

    Page<Deposit> findAllDepositPage(DepositParams params);

    Page<Deposit> findAllMaximumRateDepositPage(MaximumRateDepositParams params);

    void deleteById(long id);

    List<ScrapedDeposit> findAllScrapedDeposits();

}
