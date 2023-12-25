package ru.cobp.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.currency.CurrencyRateResponseDto;
import ru.cobp.backend.model.currency.CurrencyRate;

import java.util.List;

@Mapper
@Component
public interface CurrencyRateMapper {

    @Mapping(target = "base", source = "currencyRate.base.code")
    @Mapping(target = "name", source = "currencyRate.base.currency")
    @Mapping(target = "rate", source = "currencyRate.actualRate")
    @Mapping(target = "diff", source = "currencyRate.ratesDifference")
    CurrencyRateResponseDto toCurrencyRateResponseDto(CurrencyRate currencyRate);

    List<CurrencyRateResponseDto> toCurrencyRateResponseDtos(List<CurrencyRate> currencyRates);

}
