package ru.cobp.backend.service.currency;

import ru.cobp.backend.dto.currency.CurrencyDto;
import ru.cobp.backend.model.currency.Currency;

import java.util.List;

public interface CurrencyService {

    CurrencyDto create(CurrencyDto newCurrency);

    CurrencyDto update(Long currencyId, CurrencyDto updCurrency);

    Currency getById(Long currencyId);

    List<CurrencyDto> getAll();

    void deleteById(Long currencyId);
}
