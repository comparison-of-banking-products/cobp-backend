package ru.cobp.backend.service.credit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditMapper;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.exception.NotFoundException;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.repository.bank.BankRepository;
import ru.cobp.backend.repository.credit.CreditRepository;
import ru.cobp.backend.repository.currency.CurrencyRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class CreditAdminServiceImpl implements CreditAdminService {

    private final CreditRepository creditRepository;

    private final BankRepository bankRepository;

    private final CurrencyRepository currencyRepository;

    @Override
    public CreditDto create(NewCreditDto newCreditDto) {
        Bank bank = bankRepository.findById(newCreditDto.getBanksBic()).orElseThrow(() ->
                new NotFoundException("Bank not with bic = " + newCreditDto.getBanksBic() + " was not found"));
        Currency currency = currencyRepository.findById(newCreditDto.getCurrenciesNum()).orElseThrow(() ->
                new NotFoundException("Currency with id = " + newCreditDto.getCurrenciesNum() + " was not found"));
        Credit credit = CreditMapper.toCredit(newCreditDto, bank, currency);
        creditRepository.save(credit);
        return CreditMapper.toCreditDto(credit);
    }

    @Override
    public CreditDto update(Long id, CreditDto creditDto) {
        Credit credit = creditRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Credit with id = " + id + " was not found"));
        if (creditDto.getIsActive() != null) {
            credit.setIsActive(creditDto.getIsActive());
        }
        if (creditDto.getBanksBic() != null) {
            if (bankRepository.findById(creditDto.getBanksBic()).isPresent()) {
                credit.setBank(bankRepository.findById(creditDto.getBanksBic()).get());
            } else {
                throw new NotFoundException("Bank not with bic = " + creditDto.getBanksBic() + " was not found");
            }
        }
        if (creditDto.getName() != null) {
            credit.setName(creditDto.getName());
        }
        if (creditDto.getProductUrl() != null) {
            credit.setProductUrl(creditDto.getProductUrl());
        }
        if (creditDto.getCurrenciesNum() != null) {
            if (currencyRepository.findById(creditDto.getCurrenciesNum()).isPresent()) {
                credit.setCurrency(currencyRepository.findById(creditDto.getCurrenciesNum()).get());
            } else {
                throw new NotFoundException("Currency with id = " + creditDto.getCurrenciesNum() + " was not found");
            }
        }
        if (creditDto.getRate() != null) {
            credit.setRate(creditDto.getRate());
        }
        if (creditDto.getMinAmount() != null) {
            credit.setAmountMin(creditDto.getMinAmount());
        }
        if (creditDto.getMaxAmount() != null) {
            credit.setAmountMax(credit.getAmountMax());
        }
        if (creditDto.getTerm() != null) {
            credit.setTerm(creditDto.getTerm());
        }
        return CreditMapper.toCreditDto(creditRepository.save(credit));
    }

    @Override
    public void delete(Long id) {
        if (creditRepository.findById(id).isPresent()) {
            creditRepository.deleteById(id);
        } else {
            throw new NotFoundException("Credit with id = " + id + " was not found");
        }
    }

}
