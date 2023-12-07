package ru.cobp.backend.credit.service;

import ru.cobp.backend.credit.dto.CreditDto;
import ru.cobp.backend.credit.dto.CreditParams;

import java.util.List;

public interface CreditService {
    List<CreditDto> getAll(CreditParams params);

    CreditDto getById(long id);

}