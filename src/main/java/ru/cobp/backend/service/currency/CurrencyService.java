package ru.cobp.backend.service.currency;

import ru.cobp.backend.model.currency.Currency;

import java.util.List;

public interface CurrencyService {

    Currency create(Currency newCurrency);

    Currency update(Currency updCurrency);

    Currency getByNum(String currencyNum);

    void deleteById(String currencyId);

    List<Currency> getAll();

}
