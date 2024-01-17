package ru.cobp.backend.service.currency;

import ru.cobp.backend.model.currency.Currency;

import java.util.List;

public interface CurrencyService {

    Currency create(Currency newCurrency);

    Currency update(Currency updCurrency);

    Currency getById(Long currencyId);

    void deleteById(Long currencyId);

    List<Currency> getAll();

}
