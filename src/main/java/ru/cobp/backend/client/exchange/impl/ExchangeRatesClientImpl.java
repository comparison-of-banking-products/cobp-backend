package ru.cobp.backend.client.exchange.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.cobp.backend.client.exchange.ExchangeRatesClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeRatesClientImpl implements ExchangeRatesClient {

    @Value("${exchange.rates.uri}")
    private final String exchangeRatesUri;

    @Value("${exchange.rates.apikey}")
    private final String exchangeRatesApikey;

    @Override
    public List<ExchangeRates> getExchangeRates() {
        throw new UnsupportedOperationException();
    }

}
