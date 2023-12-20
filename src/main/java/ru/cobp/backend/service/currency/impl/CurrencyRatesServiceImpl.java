package ru.cobp.backend.service.currency.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.client.exchange.ExchangeRatesClient;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.model.currency.CurrencyRate;
import ru.cobp.backend.model.exchange.ExchangeRate;
import ru.cobp.backend.repository.currency.CurrencyRatesRepository;
import ru.cobp.backend.service.currency.CurrencyRatesService;
import ru.cobp.backend.service.currency.CurrencyService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    @Transactional
    private void saveAll(List<CurrencyRate> rates) {
        currencyRatesRepository.saveAll(rates);
    }

    @Transactional
    private void deleteAll() {
        currencyRatesRepository.deleteAll();
    }

    private List<ExchangeRate> getExchangeRates(Set<String> codes) {
        return exchangeRatesClient.getExchangeRates(codes);
    }

    @Scheduled(fixedDelay = 3_600_000)
    void getAndSaveExchangeRates() {
        this.deleteAll();

        Map<String, Currency> codeToCurrency = currencyService.findAll()
                .stream()
                .collect(Collectors
                        .toMap(Currency::getCode, Function.identity()));

        List<CurrencyRate> currencyRates = this.getExchangeRates(codeToCurrency.keySet())
                .stream()
                .map(er -> this.toCurrencyRate(er, codeToCurrency))
                .toList();

        this.saveAll(currencyRates);
    }

    private CurrencyRate toCurrencyRate(ExchangeRate er, Map<String, Currency> codeToCurrency) {
        Currency base = codeToCurrency.get(er.getBase());
        Currency quote = codeToCurrency.get(er.getQuote());
        Double rate = er.getRate();

        return new CurrencyRate(null, base, quote, rate);
    }

}
