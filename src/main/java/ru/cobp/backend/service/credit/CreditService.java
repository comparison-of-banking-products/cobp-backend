package ru.cobp.backend.service.credit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditParams;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.model.credit.Credit;

import java.util.List;

public interface CreditService {

    Page<Credit> getAllMinimumRateCreditPage(int amount, int term, List<String> bics, Pageable pageable);

    List<Credit> getAll(CreditParams params, Pageable pageable);

    Credit getById(long id);

    Credit create(NewCreditDto newCreditDto);

    Credit update(Long id, CreditDto creditDto);

    void delete(Long id);

}
