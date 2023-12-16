package ru.cobp.backend.service.deposit;

import ru.cobp.backend.model.deposit.Deposit;

import java.util.List;

public interface DepositService {

    Deposit findDeposit(Integer amount, Integer term, Double rate);

    Deposit findMaximumRateDeposit(Integer amount, Integer term);

    List<Deposit> findDeposits(Integer amount, Integer term, Double rate);

    List<Deposit> findMaximumRateDeposits(Integer amount, Integer term);


}
