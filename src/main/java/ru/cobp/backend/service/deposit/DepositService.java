package ru.cobp.backend.service.deposit;

import org.springframework.data.domain.Pageable;
import ru.cobp.backend.model.deposit.Deposit;

import java.util.List;

public interface DepositService {

    List<Deposit> findAllMaximumRateDeposits(int amount, int term, Pageable page);

}
