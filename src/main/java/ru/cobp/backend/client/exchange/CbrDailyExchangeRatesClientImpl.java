package ru.cobp.backend.client.exchange;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.cobp.backend.dto.exchange.CbrDailyResponseDto;
import ru.cobp.backend.dto.exchange.ValuteResponseDto;
import ru.cobp.backend.exception.ExceptionUtil;
import ru.cobp.backend.model.exchange.ExchangeRate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CbrDailyExchangeRatesClientImpl implements ExchangeRatesClient {

    private static final String CBR_DAILY_URL = "https://www.cbr-xml-daily.ru/daily_json.js";

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    @Override
    public List<ExchangeRate> getExchangeRates(Set<String> currencyCodes) {
        String json = restTemplate.getForObject(CBR_DAILY_URL, String.class);
        try {
            CbrDailyResponseDto dto = objectMapper.readValue(json, CbrDailyResponseDto.class);

            final String quoteCode = "RUB";
            LocalDateTime actDate = dto.getDate();
            LocalDateTime prevDate = dto.getPreviousDate();
            Map<String, ValuteResponseDto> codeToValute = dto.getValute();

            List<ExchangeRate> exchangeRates = new ArrayList<>();

            for (String curr : currencyCodes) {
                if (codeToValute.containsKey(curr)) {
                    ValuteResponseDto valute = codeToValute.get(curr);

                    String baseCode = valute.getCharCode();
                    Integer nominal = valute.getNominal();
                    Double actRate = valute.getValue() / nominal;
                    Double prevRate = valute.getPrevious() / nominal;

                    ExchangeRate er = new ExchangeRate(actDate, baseCode, quoteCode, actRate, prevRate, prevDate);
                    exchangeRates.add(er);
                }
            }

            return exchangeRates;

        } catch (JsonProcessingException ex) {
            throw ExceptionUtil.getExchangeRatesProcessingFailedException(ex);
        }
    }

}
