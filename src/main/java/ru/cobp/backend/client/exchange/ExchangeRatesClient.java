package ru.cobp.backend.client.exchange;

import ru.cobp.backend.model.exchange.ExchangeRate;

import java.util.List;
import java.util.Set;

public interface ExchangeRatesClient {

    List<ExchangeRate> getExchangeRates(Set<String> currencyCodes);

}
