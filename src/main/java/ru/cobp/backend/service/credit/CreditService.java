package ru.cobp.backend.service.credit;

import org.springframework.data.domain.Pageable;
import ru.cobp.backend.model.credit.Credit;

import java.util.List;

public interface CreditService {

    List<Credit> findAllMinimumRateCredits(int amount, int term, Pageable pageable);

}
