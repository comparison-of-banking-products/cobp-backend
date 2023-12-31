package ru.cobp.backend.service.credit;

import org.springframework.data.domain.Pageable;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditParams;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.model.credit.Credit;

import java.util.List;

public interface CreditService {

    List<Credit> findAllMinimumRateCredits(int amount, int term, Pageable pageable);

    List<Credit> getAll(CreditParams params);

    Credit getById(long id);

    Credit create(NewCreditDto newCreditDto);

    Credit update(Long id, CreditDto creditDto);

    void delete(Long id);

}
