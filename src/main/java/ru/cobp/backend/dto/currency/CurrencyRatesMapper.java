package ru.cobp.backend.dto.currency;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.model.currency.CurrencyRate;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CurrencyRatesMapper {

    public static List<CurrencyRateResponseDto> toDto(List<CurrencyRate> o) {
        throw new UnsupportedOperationException();
    }

}
