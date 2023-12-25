package ru.cobp.backend.service.bank;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.dto.bank.NewBankDto;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.repository.bank.BankRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    @Override
    public NewBankDto create(NewBankDto newBank) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public NewBankDto update(Long bic, NewBankDto updBank) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Bank getByBic(Long bic) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void deleteByBic(Long bic) {

    }

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

}
