package ru.cobp.backend.service.currency;

import ru.cobp.backend.dto.currency.CurrencyDto;
import ru.cobp.backend.model.currency.Currency;

import java.util.List;

public interface CurrencyService {

    CurrencyDto create(CurrencyDto newCurrency);

    CurrencyDto update(Long currencyId, CurrencyDto updCurrency);

    Currency getById(Long currencyId);

    void deleteById(Long currencyId);

    List<Currency> getAll();

}
