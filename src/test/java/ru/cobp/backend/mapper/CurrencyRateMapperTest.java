package ru.cobp.backend.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.dto.currency.CurrencyRateResponseDto;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.model.currency.CurrencyRate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CurrencyRateMapperTest {

    @Autowired
    private CurrencyRateMapper currencyRateMapper;

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
