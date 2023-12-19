package ru.cobp.backend.service.currency.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.client.exchange.ExchangeRatesClient;
import ru.cobp.backend.client.exchange.impl.ExchangeRates;
import ru.cobp.backend.model.currency.CurrencyRate;
import ru.cobp.backend.repository.currency.CurrencyRatesRepository;
import ru.cobp.backend.service.currency.CurrencyRatesService;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CurrencyRatesServiceImpl implements CurrencyRatesService {

    private final CurrencyRatesRepository currencyRatesRepository;

    private final ExchangeRatesClient exchangeRatesClient;

    @Override
    public List<CurrencyRate> getCurrencyRates() {
        return currencyRatesRepository.findAll();
    }

    private List<CurrencyRate> getExchangeRates() {
        List<ExchangeRates> rates = exchangeRatesClient.getExchangeRates();
        return toCurrencyRates(rates);
    }

    private List<CurrencyRate> toCurrencyRates(List<ExchangeRates> rates) {
        throw new UnsupportedOperationException();
    }

    private void saveAll(List<CurrencyRate> rates) {
        currencyRatesRepository.saveAll(rates);
    }

    @Scheduled(fixedDelay = 3_600_000)
    void getAndSaveExchangeRates() {
        List<CurrencyRate> rates = this.getExchangeRates();
        this.saveAll(rates);
    }

}
