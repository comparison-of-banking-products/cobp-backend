package ru.cobp.backend.controller.calculator;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.mapper.CalculatorMapper;
import ru.cobp.backend.model.calculator.CalculatedCredit;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
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
    @SneakyThrows
    void whenGetCalculatedDeposits_expectCalculatedDepositResponseDtos() {
        List<CalculatedDeposit> expected = TestUtils.buildGazprombankCalculatedDeposits();

        when(calculatorService.getAllMaximumRateCalculatedDeposits(
                anyInt(), anyInt(), anyBoolean(), anyBoolean(), anyBoolean(), any(Pageable.class)
        )).thenReturn(expected);

        when(calculatorMapper.toCalculatedDepositResponseDtos(anyList()))
                .thenReturn(TestUtils.buildGazprombankCalculatedDepositResponseDtos());

        mockMvc.perform(get("/v1/calculators/deposits")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .queryParam("amount", String.valueOf(100000))
                        .queryParam("term", String.valueOf(1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].annualInterest").value(expected.get(0).getAnnualInterest()));
    }

    @Test
    @SneakyThrows
    void whenGetCalculatedCredits_expectCalculatedCreditResponseDtos() {
        List<CalculatedCredit> expected = TestUtils.buildGazprombankCalculatedCredits();

        when(calculatorService.getAllMinimumRateCalculatedCredits(anyInt(), anyInt(), any(Pageable.class)))
                .thenReturn(expected);

        when(calculatorMapper.toCalculatedCreditResponseDtos(anyList()))
                .thenReturn(TestUtils.buildGazprombankCalculatedCreditResponseDtos());

        mockMvc.perform(get("/v1/calculators/credits")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .queryParam("amount", String.valueOf(100000))
                        .queryParam("term", String.valueOf(13)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].monthlyPayment").value(expected.get(0).getMonthlyPayment()));
    }

}
