package ru.cobp.backend.client.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.cobp.backend.dto.exchange.ExchangeRatesMapper;
import ru.cobp.backend.dto.exchange.ExchangeRatesResponseDto;
import ru.cobp.backend.exception.ExceptionUtil;
import ru.cobp.backend.model.exchange.ExchangeRates;

@Service
@RequiredArgsConstructor
public class CbrExchangeRatesClientImpl implements ExchangeRatesClient {

    private final RestTemplate restTemplate;

    @Value("${exchange.rates.url}")
    private final String exchangeRatesUrl;

    @Override
    public ExchangeRates getExchangeRates() {
        String json = restTemplate.getForObject(exchangeRatesUrl, String.class);
        try {
            ExchangeRatesResponseDto dto = new ObjectMapper().readValue(json, ExchangeRatesResponseDto.class);
            return ExchangeRatesMapper.toExchangeRates(dto);

        } catch (JsonProcessingException e) {
            throw ExceptionUtil.getExchangeRatesProcessingFailedException();
        }
    }

}
