package ru.cobp.backend.dto.exchange;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.model.exchange.ExchangeRates;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExchangeRatesMapper {

    public static ExchangeRates toExchangeRates(ExchangeRatesResponseDto dto) {
        ExchangeRates o = new ExchangeRates();

        o.setTimestamp(dto.getTimestamp());
        o.setBase(dto.getBase());
        o.setQuotes(dto.getRates());

        return o;
    }

}
