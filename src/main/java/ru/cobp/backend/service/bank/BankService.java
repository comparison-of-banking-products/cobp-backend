package ru.cobp.backend.service.bank;

import ru.cobp.backend.dto.bank.NewBankDto;
import ru.cobp.backend.model.bank.Bank;

import java.util.List;

public interface BankService {

    NewBankDto create(NewBankDto newBank);

    NewBankDto update(String bic, NewBankDto updBank);

    Bank getByBic(String bic);

    void deleteByBic(String bic);

    List<Bank> getAll();

}
