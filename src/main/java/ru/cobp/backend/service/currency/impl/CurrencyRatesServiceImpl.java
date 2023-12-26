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

import java.time.LocalDateTime;
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
    private void deleteAllInBatch() {
        currencyRatesRepository.deleteAllInBatch();
    }

    private List<ExchangeRate> getExchangeRates(Set<String> codes) {
        return exchangeRatesClient.getExchangeRates(codes);
    }

    @Scheduled(fixedDelayString = "${exchange.rates.update-delay}")
    @Transactional
    void getAndSaveExchangeRates() {
        this.deleteAllInBatch();

        Map<String, Currency> codeToCurrency = currencyService.getAll()
                .stream()
                .collect(Collectors
                        .toMap(Currency::getCode, Function.identity()));

        List<CurrencyRate> currencyRates = this.getExchangeRates(codeToCurrency.keySet())
                .stream()
                .map(er -> this.toCurrencyRate(er, codeToCurrency))
                .toList();

        this.saveAll(currencyRates);
    }

    private CurrencyRate toCurrencyRate(ExchangeRate exchangeRate, Map<String, Currency> codeToCurrency) {
        LocalDateTime actDate = exchangeRate.getActualDate();
        Currency base = codeToCurrency.get(exchangeRate.getBaseCode());
        Currency quote = codeToCurrency.get(exchangeRate.getQuoteCode());
        Double actRate = exchangeRate.getActualRate();
        Double prevRate = exchangeRate.getPreviousRate();
        LocalDateTime prevDate = exchangeRate.getPreviousDate();

        return new CurrencyRate(null, actDate, base, quote, actRate, prevRate, prevDate, null);
    }

}
