package ru.cobp.backend.service.credit;

import org.springframework.data.domain.Page;
import ru.cobp.backend.dto.calculator.CreditCalculatorParams;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditParams;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.model.credit.Credit;

import java.util.List;

public interface CreditService {

    List<Credit> getAll(CreditParams params, int page, int size);

    Credit getById(long id);

    Credit create(NewCreditDto newCreditDto);

    Credit update(Long id, CreditDto creditDto);

    void delete(Long id);

    Page<Credit> getAllMinimumRateCreditPage(CreditCalculatorParams params);

}
