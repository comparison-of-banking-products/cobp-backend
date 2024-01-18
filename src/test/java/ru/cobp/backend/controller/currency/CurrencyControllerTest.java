package ru.cobp.backend.controller.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.cobp.backend.dto.currency.CurrencyCreateUpdateDto;
import ru.cobp.backend.dto.currency.CurrencyResponseDto;
import ru.cobp.backend.mapper.CurrencyRateMapper;
import ru.cobp.backend.service.currency.CurrencyRatesService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CurrencyControllerTest {

    static CurrencyCreateUpdateDto createUpdateDto;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CurrencyRatesService currencyRatesService;

    @MockBean
    CurrencyRateMapper currencyRateMapper;

    @BeforeEach
    void init() {
        createUpdateDto = CurrencyCreateUpdateDto.builder()
                .num(124L)
                .code("CAD")
                .currency("Канадский доллар")
                .build();
    }

    @Test
    @SneakyThrows
    void create() {
        mockMvc.perform(post("/v1/currencies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUpdateDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.num").value(createUpdateDto.getNum()))
                .andExpect(jsonPath("$.code").value(createUpdateDto.getCode()))
                .andExpect(jsonPath("$.currency").value(createUpdateDto.getCurrency()));

    }

    @Test
    @SneakyThrows
    void update() {
        mockMvc.perform(put("/v1/currencies/{num}", 643L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUpdateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(createUpdateDto.getCode()))
                .andExpect(jsonPath("$.currency").value(createUpdateDto.getCurrency()));
    }

    @Test
    @SneakyThrows
    void getAll() {
        MvcResult result = mockMvc.perform(get("/v1/currencies")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        List<CurrencyResponseDto> actual = List.of(objectMapper.readValue(
                result.getResponse().getContentAsString(),
                CurrencyResponseDto[].class));

        assertNotNull(actual);
        assertEquals(actual.size(), 7);
        assertEquals(actual.get(0).getCode(), "CNY");
    }

    @Test
    @SneakyThrows
    void getById() {
        mockMvc.perform(get("/v1/currencies/{num}", 643L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUpdateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("RUB"))
                .andExpect(jsonPath("$.currency").value("Российский рубль"));
    }

    @Test
    @SneakyThrows
    void deleteById() {
        mockMvc.perform(delete("/v1/currencies/{num}", 643L))
                .andExpect(status().isNoContent());
    }
}