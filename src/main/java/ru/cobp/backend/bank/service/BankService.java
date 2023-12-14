package ru.cobp.backend.bank.service;

import ru.cobp.backend.bank.dto.NewBankDto;
import ru.cobp.backend.bank.dto.ResponseBankDto;

import java.util.List;

public interface BankService {
    NewBankDto create(NewBankDto newBank);

    NewBankDto update(Long bic, NewBankDto updBank);

    ResponseBankDto getByBic(Long bic);

    void deleteByBic(Long bic);

    List<ResponseBankDto> getAll();
}
