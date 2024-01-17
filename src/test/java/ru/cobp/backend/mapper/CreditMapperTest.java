package ru.cobp.backend.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.dto.bank.BankResponseDto;
import ru.cobp.backend.dto.bank.BankShortResponseDto;
import ru.cobp.backend.dto.credit.CreditResponseDto;
import ru.cobp.backend.dto.credit.CreditShortResponseDto;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.dto.currency.CurrencyResponseDto;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.currency.Currency;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreditMapperTest {

    @Autowired
    private CreditMapper creditMapper;

    @Test
    void whenMapCredit_expectCreditResponseDto() {
        Credit credit = TestUtils.buildGazprombankCredit();
        Bank bank = credit.getBank();
        Currency currency = credit.getCurrency();

        CreditResponseDto creditResponseDto = creditMapper.toCreditResponseDto(credit);
        assertNotNull(creditResponseDto);
        assertEquals(credit.getId(), creditResponseDto.getId());
        assertEquals(credit.getName(), creditResponseDto.getName());
        assertEquals(credit.getProductUrl(), creditResponseDto.getProductUrl());
        assertEquals(credit.getIsActive(), creditResponseDto.getIsActive());
        assertEquals(credit.getAmountMin(), creditResponseDto.getAmountMin());
        assertEquals(credit.getAmountMax(), creditResponseDto.getAmountMax());
        assertEquals(credit.getTerm(), creditResponseDto.getTerm());
        assertEquals(credit.getRate(), creditResponseDto.getRate());
        assertEquals(credit.getPaymentType(), creditResponseDto.getPaymentType());

        BankResponseDto bankResponseDto = creditResponseDto.getBank();
        assertNotNull(bankResponseDto);
        assertEquals(bank.getBic(), bankResponseDto.getBic());

        CurrencyResponseDto currencyResponseDto = creditResponseDto.getCurrency();
        assertNotNull(currencyResponseDto);
        assertEquals(currency.getNum(), currencyResponseDto.getNum());
    }

    @Test
    void whenMapCredit_expectCreditShortResponseDto() {
        Credit credit = TestUtils.buildGazprombankCredit();
        Bank bank = credit.getBank();

        CreditShortResponseDto creditShortResponseDto = creditMapper.toCreditShortResponseDto(credit);
        assertNotNull(creditShortResponseDto);
        assertEquals(credit.getName(), creditShortResponseDto.getName());
        assertEquals(credit.getProductUrl(), creditShortResponseDto.getProductUrl());
        assertEquals(credit.getTerm(), creditShortResponseDto.getTerm());
        assertEquals(credit.getRate(), creditShortResponseDto.getRate());

        BankShortResponseDto bankShortResponseDto = creditShortResponseDto.getBank();
        assertNotNull(bankShortResponseDto);
        assertEquals(bank.getName(), bankShortResponseDto.getName());
    }

    @Test
    void whenMapCredits_expectCreditResponseDtos() {
        List<Credit> credits = TestUtils.buildCredits();

        List<CreditResponseDto> dtos = creditMapper.toCreditResponseDtos(credits);
        assertNotNull(dtos);
        assertEquals(credits.size(), dtos.size());
        assertEquals(credits.get(0).getId(), dtos.get(0).getId());
    }

    @Test
    void whenMapNewCreditDto_expectCredit() {
        NewCreditDto newCreditDto = TestUtils.buildNewGazprombankCreditDto();

        Credit credit = creditMapper.toCredit(newCreditDto);
        assertNotNull(credit);
        assertEquals(newCreditDto.getName(), credit.getName());
        assertEquals(newCreditDto.getProductUrl(), credit.getProductUrl());
        assertEquals(newCreditDto.getIsActive(), credit.getIsActive());
        assertEquals(newCreditDto.getAmountMin(), credit.getAmountMin());
        assertEquals(newCreditDto.getAmountMax(), credit.getAmountMax());
        assertEquals(newCreditDto.getTerm(), credit.getTerm());
        assertEquals(newCreditDto.getRate(), credit.getRate());
        assertEquals(newCreditDto.getPaymentType(), credit.getPaymentType());
        assertNull(credit.getBank());
        assertNull(credit.getCurrency());
    }

}
