package ru.cobp.backend.bank.service;

import org.springframework.stereotype.Service;
import ru.cobp.backend.bank.dto.BankDto;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Override
    public BankDto create(BankDto newBank) {
        return null;
    }

    @Override
    public BankDto update(Long bankId, BankDto updBank) {
        return null;
    }

    @Override
    public BankDto getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<BankDto> getAll() {
        return null;
    }

}
