package ru.cobp.backend.service.currency.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.dto.currency.CurrencyDto;
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
    public CurrencyDto create(CurrencyDto newCurrency) {
        return null;
    }

    @Override
    public CurrencyDto update(Long currencyId, CurrencyDto updCurrency) {
        return null;
    }

    @Override
    public Currency getById(Long currencyId) {
        return null;
    }

    @Override
    public void deleteById(Long currencyId) {

    }

    @Override
    public List<Currency> getAll() {
        return currencyRepository.findAll();
    }

}
