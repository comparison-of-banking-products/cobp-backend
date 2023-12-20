package ru.cobp.backend.client.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.cobp.backend.dto.exchange.ExchangeRatesResponseDto;
import ru.cobp.backend.exception.ExceptionUtil;
import ru.cobp.backend.model.exchange.ExchangeRate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CbrExchangeRatesClientImpl implements ExchangeRatesClient {

    private final RestTemplate restTemplate;

    @Value("${exchange.rates.url}")
    private final String exchangeRatesUrl;

    @Override
    public List<ExchangeRate> getExchangeRates(Set<String> currencyCodes) {
        String json = restTemplate.getForObject(exchangeRatesUrl, String.class);
        try {
            ExchangeRatesResponseDto dto = new ObjectMapper().readValue(json, ExchangeRatesResponseDto.class);

            LocalDateTime ts = dto.getTimestamp();
            String base = dto.getBase();
            Map<String, Double> codeToRate = dto.getRates();
            List<ExchangeRate> exchangeRates = new ArrayList<>();

            for (String quote : currencyCodes) {
                if (codeToRate.containsKey(quote)) {
                    ExchangeRate er = new ExchangeRate(ts, base, quote, codeToRate.get(quote));
                    exchangeRates.add(er);
                }
            }

            return exchangeRates;

        } catch (JsonProcessingException e) {
            throw ExceptionUtil.getExchangeRatesProcessingFailedException();
        }
    }

}
