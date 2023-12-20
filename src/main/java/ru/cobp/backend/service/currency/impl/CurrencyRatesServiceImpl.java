package ru.cobp.backend.service.currency.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.client.exchange.ExchangeRatesClient;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.model.currency.CurrencyRate;
import ru.cobp.backend.model.exchange.ExchangeRates;
import ru.cobp.backend.repository.currency.CurrencyRatesRepository;
import ru.cobp.backend.service.currency.CurrencyRatesService;
import ru.cobp.backend.service.currency.CurrencyService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CurrencyRatesServiceImpl implements CurrencyRatesService {

    private final CurrencyService currencyService;

    private final CurrencyRatesRepository currencyRatesRepository;

    private final ExchangeRatesClient exchangeRatesClient;

    @Override
    public List<CurrencyRate> getCurrencyRates() {
        return currencyRatesRepository.findAll();
    }

    private List<CurrencyRate> getExchangeRates() {
        ExchangeRates rates = exchangeRatesClient.getExchangeRates();
        return toCurrencyRates(rates);
    }

    private List<CurrencyRate> toCurrencyRates(ExchangeRates exchangeRates) {
        List<Currency> currencies = currencyService.findAll();

//        currencies.stream()
//                .map(c -> exchangeRates.getQuotes().)

        List<CurrencyRate> rates = new ArrayList<>();

        for (Currency currency : currencies) {
            if (exchangeRates.getQuotes().containsKey(currency.getCode())) {
                CurrencyRate e = new CurrencyRate(null, exchangeRates.getBase(), currency.getCode(), exchangeRates.getQuotes().get(currency.getCode()));
                rates.add(e);
            }
        }


        return exchangeRates

    }

    @Transactional
    private void saveAll(List<CurrencyRate> currencyRates) {
        currencyRatesRepository.saveAll(currencyRates);
    }

    @Scheduled(fixedDelay = 3_600_000)
    void getAndSaveExchangeRates() {
        List<CurrencyRate> rates = this.getExchangeRates();
        this.saveAll(rates);
    }

}
