package ru.cobp.backend.service.deposit;

import ru.cobp.backend.model.deposit.Deposit;

public interface DepositService {

    Deposit findMaximumRateDepositByAmountAndTerm(int amount, int term);

}
