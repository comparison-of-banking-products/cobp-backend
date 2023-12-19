package ru.cobp.backend.service.credit;

import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.NewCreditDto;

public interface CreditAdminService {

    CreditDto create(NewCreditDto newCreditDto);

    CreditDto update(Long id, CreditDto creditDto);

    void delete(Long id);

}
