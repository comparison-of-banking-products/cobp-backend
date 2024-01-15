package ru.cobp.backend.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.dto.bank.BankShortResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedCreditResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedDepositResponseDto;
import ru.cobp.backend.dto.credit.CreditShortResponseDto;
import ru.cobp.backend.dto.deposit.DepositShortResponseDto;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.calculator.CalculatedCredit;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.deposit.Deposit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CalculatorMapperTest {

    CalculatorMapper calculatorMapper;

    @BeforeEach
    void setUp() {
        calculatorMapper = Mappers.getMapper(CalculatorMapper.class);
    }

    @Test
    void whenMapCalculatedDeposit_expectCalculatedDepositResponseDto() {
        CalculatedDeposit calculatedDeposit = TestUtils.buildGazprombankCalculatedDeposit();
        Deposit deposit = calculatedDeposit.getDeposit();
        Bank bank = deposit.getBank();

        CalculatedDepositResponseDto calculatedDepositResponseDto = calculatorMapper.toCalculatedDepositResponseDto(calculatedDeposit);
        assertNotNull(calculatedDepositResponseDto);
        assertEquals(calculatedDeposit.getAnnualInterest(), calculatedDepositResponseDto.getAnnualInterest());
        assertEquals(calculatedDeposit.getMaturityInterest(), calculatedDepositResponseDto.getMaturityInterest());
        assertEquals(calculatedDeposit.getTotalAmount(), calculatedDepositResponseDto.getTotalAmount());

        DepositShortResponseDto depositShortResponseDto = calculatedDepositResponseDto.getDeposit();
        assertNotNull(depositShortResponseDto);
        assertEquals(deposit.getName(), depositShortResponseDto.getName());

        BankShortResponseDto bankShortResponseDto = depositShortResponseDto.getBank();
        assertNotNull(bankShortResponseDto);
        assertEquals(bank.getName(), bankShortResponseDto.getName());
    }

    @Test
    void whenMapCalculatedCredit_expectCalculatedCreditResponseDto() {
        CalculatedCredit calculatedCredit = TestUtils.buildGazprombankCalculatedCredit();
        Credit credit = calculatedCredit.getCredit();
        Bank bank = credit.getBank();

        CalculatedCreditResponseDto calculatedCreditResponseDto = calculatorMapper.toCalculatedCreditResponseDto(calculatedCredit);
        assertNotNull(calculatedCreditResponseDto);
        assertEquals(calculatedCredit.getMonthlyPayment(), calculatedCreditResponseDto.getMonthlyPayment());
        assertEquals(calculatedCredit.getTotalPayments(), calculatedCreditResponseDto.getTotalPayments());
        assertEquals(calculatedCredit.getMaturityInterest(), calculatedCreditResponseDto.getMaturityInterest());

        CreditShortResponseDto creditShortResponseDto = calculatedCreditResponseDto.getCredit();
        assertNotNull(creditShortResponseDto);
        assertEquals(credit.getName(), creditShortResponseDto.getName());

        BankShortResponseDto bankShortResponseDto = creditShortResponseDto.getBank();
        assertNotNull(bankShortResponseDto);
        assertEquals(bank.getName(), bankShortResponseDto.getName());
    }

    @Test
    void whenMapCalculatedDeposits_expectCalculatedDepositResponseDtos() {
        List<CalculatedDeposit> calculatedDeposits = TestUtils.buildGazprombankCalculatedDeposits();

        List<CalculatedDepositResponseDto> dtos = calculatorMapper.toCalculatedDepositResponseDtos(calculatedDeposits);
        assertNotNull(dtos);
        assertEquals(calculatedDeposits.size(), dtos.size());
        assertEquals(calculatedDeposits.get(0).getAnnualInterest(), dtos.get(0).getAnnualInterest());
    }

    @Test
    void whenMapCalculatedCredits_expectCalculatedCreditResponseDtos() {
        List<CalculatedCredit> calculatedCredits = TestUtils.buildGazprombankCalculatedCredits();

        List<CalculatedCreditResponseDto> dtos = calculatorMapper.toCalculatedCreditResponseDtos(calculatedCredits);
        assertNotNull(dtos);
        assertEquals(calculatedCredits.size(), dtos.size());
        assertEquals(calculatedCredits.get(0).getMonthlyPayment(), dtos.get(0).getMonthlyPayment());
    }

}
