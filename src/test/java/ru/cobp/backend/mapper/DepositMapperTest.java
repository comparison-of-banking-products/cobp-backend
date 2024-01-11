package ru.cobp.backend.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.dto.bank.BankResponseDto;
import ru.cobp.backend.dto.bank.BankShortResponseDto;
import ru.cobp.backend.dto.currency.CurrencyResponseDto;
import ru.cobp.backend.dto.deposit.DepositResponseDto;
import ru.cobp.backend.dto.deposit.DepositShortResponseDto;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.model.deposit.Deposit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DepositMapperTest {

    DepositMapper depositMapper;

    @BeforeEach
    void setUp() {
        depositMapper = Mappers.getMapper(DepositMapper.class);
    }

    @Test
    void whenMapDeposit_expectDepositResponseDto() {
        Deposit deposit = TestUtils.buildGazprombankDeposit();
        Bank bank = deposit.getBank();
        Currency currency = deposit.getCurrency();

        DepositResponseDto depositResponseDto = depositMapper.toDepositResponseDto(deposit);
        assertNotNull(depositResponseDto);
        assertEquals(deposit.getId(), depositResponseDto.getId());
        assertEquals(deposit.getName(), depositResponseDto.getName());
        assertEquals(deposit.getProductUrl(), depositResponseDto.getProductUrl());
        assertEquals(deposit.getIsActive(), depositResponseDto.getIsActive());
        assertEquals(deposit.getAmountMin(), depositResponseDto.getAmountMin());
        assertEquals(deposit.getAmountMax(), depositResponseDto.getAmountMax());
        assertEquals(deposit.getTerm(), depositResponseDto.getTerm());
        assertEquals(deposit.getRate(), depositResponseDto.getRate());
        assertEquals(deposit.getCapitalization(), depositResponseDto.getCapitalization());
        assertEquals(deposit.getReplenishment(), depositResponseDto.getReplenishment());
        assertEquals(deposit.getPartialWithdrawal(), depositResponseDto.getPartialWithdrawal());

        BankResponseDto bankResponseDto = depositResponseDto.getBank();
        assertNotNull(bankResponseDto);
        assertEquals(bank.getBic(), bankResponseDto.getBic());

        CurrencyResponseDto currencyResponseDto = depositResponseDto.getCurrency();
        assertNotNull(currencyResponseDto);
        assertEquals(currency.getNum(), currencyResponseDto.getNum());
    }

    @Test
    void whenMapDeposit_expectDepositShortResponseDto() {
        Deposit deposit = TestUtils.buildGazprombankDeposit();
        Bank bank = deposit.getBank();

        DepositShortResponseDto depositShortResponseDto = depositMapper.toDepositShortResponseDto(deposit);
        assertNotNull(depositShortResponseDto);
        assertEquals(deposit.getName(), depositShortResponseDto.getName());
        assertEquals(deposit.getProductUrl(), depositShortResponseDto.getProductUrl());
        assertEquals(deposit.getTerm(), depositShortResponseDto.getTerm());
        assertEquals(deposit.getRate(), depositShortResponseDto.getRate());
        assertEquals(deposit.getCapitalization(), depositShortResponseDto.getCapitalization());
        assertEquals(deposit.getReplenishment(), depositShortResponseDto.getReplenishment());
        assertEquals(deposit.getPartialWithdrawal(), depositShortResponseDto.getPartialWithdrawal());

        BankShortResponseDto bankShortResponseDto = depositShortResponseDto.getBank();
        assertNotNull(bankShortResponseDto);
        assertEquals(bank.getName(), bankShortResponseDto.getName());
    }

    @Test
    void whenMapDeposits_expectDepositResponseDtos() {
        List<Deposit> deposits = TestUtils.buildDeposits();

        List<DepositResponseDto> dtos = depositMapper.toDepositResponseDtos(deposits);
        assertNotNull(dtos);
        assertEquals(deposits.size(), dtos.size());
        assertEquals(deposits.get(0).getId(), dtos.get(0).getId());
    }

}
