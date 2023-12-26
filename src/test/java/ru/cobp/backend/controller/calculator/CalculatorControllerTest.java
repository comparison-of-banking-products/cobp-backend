package ru.cobp.backend.controller.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.cobp.backend.dto.bank.BankShortResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedDepositResponseDto;
import ru.cobp.backend.dto.deposit.DepositShortResponseDto;
import ru.cobp.backend.mapper.CalculatorMapper;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
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
    void given__when__then_() throws Exception {
        List<CalculatedDeposit> calculatedDeposits = buildCalculatedDeposits();
        List<CalculatedDepositResponseDto> calculatedDepositResponseDtos = buildCalculatedDepositResponseDtos();

        when(calculatorService.getAllMaximumRateCalculatedDeposits(
                anyInt(), anyInt(), anyBoolean(), anyBoolean(), anyBoolean(), any(Pageable.class)
        )).thenReturn(calculatedDeposits);

        when(calculatorMapper.toCalculatedDepositResponseDtos(anyList()))
                .thenReturn(calculatedDepositResponseDtos);

        mockMvc.perform(get("/v1/calculators/deposits")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .queryParam("amount", String.valueOf(0))
                        .queryParam("term", String.valueOf(0)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].deposit.name").value("name"));
    }

    private List<CalculatedDeposit> buildCalculatedDeposits() {
        Bank bank = new Bank(
                "000000000",
                "name",
                "legal-entity",
                "description",
                "logo",
                "url"
        );

        Currency currency = new Currency(0L, "code", "currency");

        Deposit deposit = new Deposit(
                0L,
                bank,
                "name",
                "product-url",
                true,
                currency,
                0,
                0,
                0,
                0d,
                false,
                false,
                false
        );

        CalculatedDeposit calculatedDeposit = new CalculatedDeposit(
                deposit,
                0d,
                0d,
                0d
        );

        return List.of(calculatedDeposit);
    }

    private List<CalculatedDepositResponseDto> buildCalculatedDepositResponseDtos() {
        BankShortResponseDto bank = new BankShortResponseDto(
                "name",
                "logo"
        );

        DepositShortResponseDto deposit = new DepositShortResponseDto(
                bank,
                "name",
                "product-url",
                0,
                0d
        );

        CalculatedDepositResponseDto calculatedDeposit = new CalculatedDepositResponseDto(
                deposit,
                0d,
                0d,
                0d
        );

        return List.of(calculatedDeposit);
    }

    @Test
    void getAllCalculatedDeposits() {
    }

    @Test
    void getAllCalculatedCredits() {
    }

}