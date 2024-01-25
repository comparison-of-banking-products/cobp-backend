package ru.cobp.backend.service.currency.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.exception.ExceptionUtil;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.repository.currency.CurrencyRepository;
import ru.cobp.backend.service.currency.CurrencyService;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    @Override
    @Transactional
    public Currency create(Currency newCurrency) {
        return currencyRepository.save(newCurrency);
    }

    @Override
    @Transactional
    public Currency update(Currency updCurrency) {
        return currencyRepository.save(updCurrency);
    }

    @Override
    public Currency getByNum(String currencyNum) {
        return currencyRepository.findById(currencyNum).orElseThrow(
                () -> ExceptionUtil.getCurrencyNotFoundException(currencyNum));
    }

    @Override
    @Transactional
    public void deleteById(String currencyNum) {
        currencyRepository.deleteById(currencyNum);
    }

    @Override
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }

}
