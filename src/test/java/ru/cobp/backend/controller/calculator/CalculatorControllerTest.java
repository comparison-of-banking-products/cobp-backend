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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import ru.cobp.backend.client.exchange.ExchangeRatesClient;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.dto.calculator.CalculatedCreditListResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedDepositListResponseDto;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class CalculatorControllerTest {

    private static final String GAZPROMBANK_BIC = "044525823";

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @SuppressWarnings("unused")
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
                        .queryParam("bics", GAZPROMBANK_BIC)
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
        var expected = TestUtils.buildGazprombankCalculatedCreditListResponseDto();

        String contentAsString = mockMvc.perform(get("/v1/calculators/credits")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .characterEncoding(StandardCharsets.UTF_8)
                        .queryParam("amount", String.valueOf(100_000))
                        .queryParam("term", String.valueOf(13))
                        .queryParam("bics", GAZPROMBANK_BIC)
                        .queryParam("size", String.valueOf(1)))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(StandardCharsets.UTF_8);

        var actual = objectMapper.readValue(contentAsString, CalculatedCreditListResponseDto.class);

        assertEquals(expected, actual);
    }

}
