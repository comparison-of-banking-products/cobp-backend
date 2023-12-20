package ru.cobp.backend.dto.currency;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.model.currency.CurrencyRate;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CurrencyRateMapper {

    public static List<CurrencyRateResponseDto> toCurrencyRateResponseDtos(List<CurrencyRate> l) {
        return l.stream()
                .map(CurrencyRateMapper::toCurrencyRateResponseDto)
                .collect(Collectors.toList());
    }

    public static CurrencyRateResponseDto toCurrencyRateResponseDto(CurrencyRate o) {
        CurrencyRateResponseDto dto = new CurrencyRateResponseDto();

        dto.setBase(o.getBase().getCode());
        dto.setName(o.getBase().getCurrency());
        dto.setRate(o.getActualRate());
        dto.setDiff(o.getActualRate() - o.getPreviousRate());

        return dto;
    }

}
