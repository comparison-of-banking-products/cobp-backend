package ru.cobp.backend.currency.service;

import org.springframework.stereotype.Service;
import ru.cobp.backend.currency.dto.CurrencyDto;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService{

    @Override
    public CurrencyDto create(CurrencyDto newCurrency) {
        return null;
    }

    @Override
    public CurrencyDto update(Long currencyId, CurrencyDto updCurrency) {
        return null;
    }

    @Override
    public CurrencyDto getById(Long currencyId) {
        return null;
    }

    @Override
    public List<CurrencyDto> getAll() {
        return null;
    }

    @Override
    public void deleteById(Long currencyId) {

    }
}
