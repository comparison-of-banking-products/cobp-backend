package ru.cobp.backend.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.dto.bank.BankResponseDto;
import ru.cobp.backend.dto.bank.BankShortResponseDto;
import ru.cobp.backend.model.bank.Bank;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BankMapperTest {

    @Autowired
    private BankMapper bankMapper;

    @Test
    void whenMapBank_expectBankResponseDto() {
        Bank bank = TestUtils.buildGazprombank();

        BankResponseDto dto = bankMapper.toBankResponseDto(bank);
        assertNotNull(dto);
        assertEquals(bank.getBic(), dto.getBic());
        assertEquals(bank.getName(), dto.getName());
        assertEquals(bank.getLegalEntity(), dto.getLegalEntity());
        assertEquals(bank.getDescription(), dto.getDescription());
        assertEquals(bank.getLogo(), dto.getLogo());
        assertEquals(bank.getUrl(), dto.getUrl());
    }

    @Test
    void whenMapBank_expectBankShortResponseDto() {
        Bank bank = TestUtils.buildGazprombank();

        BankShortResponseDto dto = bankMapper.toBankShortResponseDto(bank);
        assertNotNull(dto);
        assertEquals(bank.getName(), dto.getName());
        assertEquals(bank.getLogo(), dto.getLogo());
    }

    @Test
    void whenMapBank_expectBankResponseDtos() {
        List<Bank> banks = TestUtils.buildBanks();

        List<BankResponseDto> dtos = bankMapper.toBankResponseDtos(banks);
        assertNotNull(dtos);
        assertEquals(banks.size(), dtos.size());
        assertEquals(banks.get(0).getBic(), dtos.get(0).getBic());
    }

}
