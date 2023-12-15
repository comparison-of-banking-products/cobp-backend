package ru.cobp.backend.service.credit;

import ru.cobp.backend.model.credit.Credit;

public interface CreditService {

    Credit findMinimumRateCreditByAmountAndTerm(int amount, int term);

}
