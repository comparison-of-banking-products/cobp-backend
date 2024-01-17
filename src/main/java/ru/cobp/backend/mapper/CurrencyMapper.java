package ru.cobp.backend.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.currency.CurrencyCreateUpdateDto;
import ru.cobp.backend.dto.currency.CurrencyResponseDto;
import ru.cobp.backend.model.currency.Currency;

import java.util.List;

@Component
@Mapper
public interface CurrencyMapper {

    CurrencyResponseDto toCurrencyResponseDto(Currency currency);

    List<CurrencyResponseDto> toCurrencyResponseDtos(List<Currency> currencies);

    Currency fromCurrencyCreateUpdateDto(CurrencyCreateUpdateDto createUpdateDto);

    default Currency updateCurrency(Currency oldCurrency, Currency updateCurrency) {
        if (updateCurrency.getCode() != null) {
            oldCurrency.setCode(updateCurrency.getCode());
        }
        if (updateCurrency.getCurrency() != null) {
            oldCurrency.setCurrency(updateCurrency.getCurrency());
        }
        return oldCurrency;
    }

}
