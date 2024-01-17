package ru.cobp.backend.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.dto.currency.CurrencyResponseDto;
import ru.cobp.backend.model.currency.Currency;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CurrencyMapperTest {

    @Autowired
    private CurrencyMapper currencyMapper;

    @Test
    void whenMapCurrency_expectCurrencyResponseDto() {
        Currency currency = TestUtils.buildRubCurrency();

        CurrencyResponseDto dto = currencyMapper.toCurrencyResponseDto(currency);
        assertNotNull(dto);
        assertEquals(currency.getNum(), dto.getNum());
        assertEquals(currency.getCode(), dto.getCode());
        assertEquals(currency.getCurrency(), dto.getCurrency());
    }

    @Test
    void whenMapCurrency_expectCurrencyResponseDtos() {
        List<Currency> currencies = TestUtils.buildCurrencies();

        List<CurrencyResponseDto> dtos = currencyMapper.toCurrencyResponseDtos(currencies);
        assertNotNull(dtos);
        assertEquals(currencies.size(), dtos.size());
        assertEquals(currencies.get(0).getNum(), dtos.get(0).getNum());
    }

}
