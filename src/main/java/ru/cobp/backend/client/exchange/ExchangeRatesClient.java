package ru.cobp.backend.client.exchange;

import ru.cobp.backend.client.exchange.impl.ExchangeRates;

import java.util.List;

public interface ExchangeRatesClient {

    List<ExchangeRates> getExchangeRates();

}
