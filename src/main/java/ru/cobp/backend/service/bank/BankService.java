package ru.cobp.backend.service.bank;

import ru.cobp.backend.dto.bank.NewBankDto;
import ru.cobp.backend.dto.bank.ResponseBankDto;

import java.util.List;

public interface BankService {
    NewBankDto create(NewBankDto newBank);

    NewBankDto update(Long bic, NewBankDto updBank);

    ResponseBankDto getByBic(Long bic);

    void deleteByBic(Long bic);

    List<ResponseBankDto> getAll();
}