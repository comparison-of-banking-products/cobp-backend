package ru.cobp.backend.bank.service;

import org.springframework.stereotype.Service;
import ru.cobp.backend.bank.dto.NewBankDto;
import ru.cobp.backend.bank.dto.ResponseBankDto;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Override
    public NewBankDto create(NewBankDto newBank) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public NewBankDto update(Long bic, NewBankDto updBank) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public ResponseBankDto getByBic(Long bic) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteByBic(Long bic) {

    }

    @Override
    public List<ResponseBankDto> getAll() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
