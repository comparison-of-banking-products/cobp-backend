package ru.cobp.backend.controller.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.cobp.backend.dto.bank.BankShortResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedCreditResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedDepositResponseDto;
import ru.cobp.backend.dto.credit.CreditShortResponseDto;
import ru.cobp.backend.dto.deposit.DepositShortResponseDto;
import ru.cobp.backend.mapper.CalculatorMapper;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.calculator.CalculatedCredit;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.service.calculator.CalculatorService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CalculatorService calculatorService;

    @MockBean
    CalculatorMapper calculatorMapper;

    @Test
    void whenGetCalculatedDeposits_expectActualDeposits() throws Exception {
        when(calculatorService.getAllMaximumRateCalculatedDeposits(
                anyInt(), anyInt(), anyBoolean(), anyBoolean(), anyBoolean(), any(Pageable.class)
        )).thenReturn(buildCalculatedDeposits());

        when(calculatorMapper.toCalculatedDepositResponseDtos(anyList()))
                .thenReturn(buildCalculatedDepositResponseDtos());

        mockMvc.perform(get("/v1/calculators/deposits")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .queryParam("amount", String.valueOf(100000))
                        .queryParam("term", String.valueOf(12)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].deposit.name").value("deposit-name"));
    }

    @Test
    void whenGetCalculatedCredits_expectActualCredits() throws Exception {
        when(calculatorService.getAllMinimumRateCalculatedCredits(anyInt(), anyInt(), any(Pageable.class)))
                .thenReturn(buildCalculatedCredits());

        when(calculatorMapper.toCalculatedCreditResponseDtos(anyList()))
                .thenReturn(buildCalculatedCreditResponseDtos());

        mockMvc.perform(get("/v1/calculators/credits")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .queryParam("amount", String.valueOf(100000))
                        .queryParam("term", String.valueOf(12)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].credit.name").value("credit-name"));
    }

    private List<CalculatedDeposit> buildCalculatedDeposits() {
        Deposit deposit = new Deposit(
                0L,
                buildBank(),
                "deposit-name",
                "deposit-product-url",
                true,
                buildCurrency(),
                0,
                0,
                0,
                0d,
                false,
                false,
                false
        );

        CalculatedDeposit calculatedDeposit = new CalculatedDeposit(
                deposit, 0d, 0d, 0d
        );

        return List.of(calculatedDeposit);
    }

    private List<CalculatedDepositResponseDto> buildCalculatedDepositResponseDtos() {
        BankShortResponseDto bank = new BankShortResponseDto(
                "bank-name", "bank-logo"
        );

        DepositShortResponseDto deposit = new DepositShortResponseDto(
                bank, "deposit-name", "deposit-product-url", 0, 0d
        );

        CalculatedDepositResponseDto calculatedDeposit = new CalculatedDepositResponseDto(
                deposit, 0d, 0d, 0d
        );

        return List.of(calculatedDeposit);
    }

    private List<CalculatedCredit> buildCalculatedCredits() {
        Credit credit = new Credit(
                0L,
                buildBank(),
                "credit-name",
                "credit-product-url",
                true,
                buildCurrency(),
                0,
                0,
                0,
                0d
        );

        CalculatedCredit calculatedCredit = new CalculatedCredit(
                credit, 0d, 0d, 0d
        );

        return List.of(calculatedCredit);
    }

    private List<CalculatedCreditResponseDto> buildCalculatedCreditResponseDtos() {
        BankShortResponseDto bank = new BankShortResponseDto("bank-name", "bank-logo");

        CreditShortResponseDto credit = new CreditShortResponseDto(
                bank, "credit-name", "credit-product-url", 0, 0d
        );

        CalculatedCreditResponseDto calculatedCreditResponseDto = new CalculatedCreditResponseDto(
                credit, 0d, 0d, 0d
        );

        return List.of(calculatedCreditResponseDto);
    }

    private Bank buildBank() {
        return new Bank("000000000",
                "bank-name",
                "bank-legal-entity",
                "bank-description",
                "bank-logo",
                "bank-url"
        );
    }

    private Currency buildCurrency() {
        return new Currency(0L, "currency-code", "currency");
    }

}
