package ru.cobp.backend.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.dto.currency.CurrencyRateResponseDto;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.model.currency.CurrencyRate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CurrencyRateMapperTest {

    CurrencyRateMapper currencyRateMapper;

    @BeforeEach
    void setUp() {
        currencyRateMapper = Mappers.getMapper(CurrencyRateMapper.class);
    }

    @Test
    void whenMapCurrencyRate_expectCurrencyRateResponseDto() {
        CurrencyRate currencyRate = TestUtils.buildUsdRubCurrencyRate();
        Currency base = currencyRate.getBase();

        CurrencyRateResponseDto dto = currencyRateMapper.toCurrencyRateResponseDto(currencyRate);
        assertNotNull(dto);
        assertEquals(base.getCode(), dto.getBase());
        assertEquals(base.getCurrency(), dto.getName());
        assertEquals(currencyRate.getActualRate(), dto.getRate());
        assertEquals(currencyRate.getRatesDifference(), dto.getDiff());
    }

    @Test
    void whenMapCurrencyRates_expectCurrencyRateResponseDtos() {
        List<CurrencyRate> currencyRates = TestUtils.buildCurrencyRates();

        List<CurrencyRateResponseDto> dtos = currencyRateMapper.toCurrencyRateResponseDtos(currencyRates);
        assertNotNull(dtos);
        assertEquals(currencyRates.size(), dtos.size());
        assertEquals(currencyRates.get(0).getActualRate(), dtos.get(0).getRate());
    }

}
