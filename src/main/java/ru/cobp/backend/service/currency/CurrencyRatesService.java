package ru.cobp.backend.service.currency;

import ru.cobp.backend.model.currency.CurrencyRate;

import java.util.List;

public interface CurrencyRatesService {

    List<CurrencyRate> getCurrencyRates();

}
