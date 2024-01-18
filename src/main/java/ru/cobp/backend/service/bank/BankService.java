package ru.cobp.backend.service.bank;

import ru.cobp.backend.dto.bank.BankSort;
import ru.cobp.backend.model.bank.Bank;

import java.util.List;

public interface BankService {

    Bank create(Bank newBank);

    Bank update(Bank updBank);

    Bank getBankByBicOrThrowException(String bic);

    void deleteByBic(String bic);

    List<Bank> getAll(BankSort sort, List<String> bics);

}
