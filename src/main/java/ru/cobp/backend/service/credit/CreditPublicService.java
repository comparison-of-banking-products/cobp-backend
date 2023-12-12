package ru.cobp.backend.service.credit;

import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditParams;

import java.util.List;

public interface CreditPublicService {
    List<CreditDto> getAll(CreditParams params);

    CreditDto getById(long id);

}
