package ru.cobp.backend.bank.service;

import ru.cobp.backend.bank.dto.BankDto;

import java.util.List;

public interface BankService {
    BankDto create(BankDto newBank);

    BankDto update(Long bankId, BankDto updBank);

    BankDto getById(Long bankId);

    void deleteById(Long bankId);

    List<BankDto> getAll();
}
