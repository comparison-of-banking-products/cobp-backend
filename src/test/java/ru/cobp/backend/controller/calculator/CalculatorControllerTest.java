package ru.cobp.backend.controller.calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import ru.cobp.backend.client.exchange.ExchangeRatesClient;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.dto.calculator.CalculatedDepositListResponseDto;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CalculatorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    ExchangeRatesClient exchangeRatesClient;

    @Test
    @SneakyThrows
    void whenGetCalculatedDeposits_expectCalculatedDepositResponseDtos() {
        var expected = TestUtils.buildGazprombankCalculatedDepositListResponseDto();

        String contentAsString = mockMvc.perform(get("/v1/calculators/deposits")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .queryParam("amount", String.valueOf(100_000))
                        .queryParam("term", String.valueOf(1))
                        .queryParam("size", String.valueOf(1)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(StandardCharsets.UTF_8);

        var actual = objectMapper.readValue(contentAsString, CalculatedDepositListResponseDto.class);

        assertEquals(expected, actual);
    }

    @Test
    @SneakyThrows
    void whenGetCalculatedCredits_expectCalculatedCreditResponseDtos() {
//        List<CalculatedCredit> expected = TestUtils.buildGazprombankCalculatedCredits();
//
//        when(calculatorService.getAllMinimumRateCalculatedCredits(anyInt(), anyInt(), anyList(), any(Pageable.class)))
//                .thenReturn(expected);
//
//        when(calculatorMapper.toCalculatedCreditResponseDtos(anyList()))
//                .thenReturn(TestUtils.buildGazprombankCalculatedCreditResponseDtos());
//
//        mockMvc.perform(get("/v1/calculators/credits")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE)
//                        .queryParam("amount", String.valueOf(100000))
//                        .queryParam("term", String.valueOf(13)))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isArray())
//                .andExpect(jsonPath("$[0].monthlyPayment").value(expected.get(0).getMonthlyPayment()));
    }

}
