package ru.cobp.backend.service.credit;

import org.springframework.data.domain.Page;
import ru.cobp.backend.dto.calculator.MinimumRateCreditParams;
import ru.cobp.backend.dto.credit.CreditParams;
import ru.cobp.backend.dto.credit.CreditUpdateDto;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.model.credit.Credit;

import java.util.List;

public interface CreditService {

    List<Credit> getAll(CreditParams params, int page, int size);

    Credit getById(long id);

    Credit create(NewCreditDto newCreditDto);

    Credit update(Long id, CreditUpdateDto creditDto);

    void delete(Long id);

    Page<Credit> getAllMinimumRateCreditPage(MinimumRateCreditParams params);

}
