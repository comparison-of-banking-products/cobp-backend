package ru.cobp.backend.service.deposit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.model.deposit.ScrapedDeposit;

import java.util.List;

public interface DepositService {

    List<Deposit> findAllDeposits(
            Integer minAmount,
            Integer maxAmount,
            Integer minTerm,
            Integer maxTerm,
            Double minRate,
            Double maxRate,
            Boolean capitalization,
            Boolean replenishment,
            Boolean partialWithdrawal,
            Pageable pageable
    );

    Page<Deposit> getAllMaximumRateDepositPage(
            int amount,
            int term,
            Boolean capitalization,
            Boolean replenishment,
            Boolean partialWithdrawal,
            List<String> bics,
            Pageable pageable
    );

    List<ScrapedDeposit> getAllScrapedDeposits();

}
