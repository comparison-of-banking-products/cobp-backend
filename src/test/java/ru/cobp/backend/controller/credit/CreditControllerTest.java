package ru.cobp.backend.controller.credit;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.dto.credit.CreditParams;
import ru.cobp.backend.dto.credit.CreditResponseDto;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.mapper.CreditMapper;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.service.credit.CreditService;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CreditController.class)
public class CreditControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    CreditService creditService;

    @MockBean
    CreditMapper creditMapper;

    @SneakyThrows
    @Test
    void createCredit() {
        NewCreditDto newCreditDto = TestUtils.buildNewGazprombankCreditDto();
        Credit credit = TestUtils.buildGazprombankCredit();

        when(creditMapper.toCreditResponseDto(credit)).thenReturn(TestUtils.toCreditResponseDto(credit));
        when(creditService.create(newCreditDto)).thenReturn(credit);

        String result = mockMvc.perform(post("/v1/credits")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(newCreditDto)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn()
                .getResponse()
                .getContentAsString(StandardCharsets.UTF_8);

        CreditResponseDto creditResponseDto = creditMapper.toCreditResponseDto(credit);
        assertEquals(objectMapper.writeValueAsString(creditResponseDto), result);
        verify(creditService).create(TestUtils.buildNewGazprombankCreditDto());

    }

    @SneakyThrows
    @Test
    void changeCredit() {
        Long creditId = 1L;
        Credit updatedCredit = TestUtils.buildGazprombankUpdatedCredit();
        CreditResponseDto updatedDto = TestUtils.toCreditResponseDto(updatedCredit);

        when(creditService.update(creditId, TestUtils.buildGazprombankCreditDto()))
                .thenReturn(updatedCredit);
        when(creditMapper.toCreditResponseDto(updatedCredit)).thenReturn(updatedDto);

        String result =  mockMvc.perform(put("/v1/credits/{id}", creditId)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(TestUtils.buildGazprombankCreditDto())))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(StandardCharsets.UTF_8);

        assertEquals(objectMapper.writeValueAsString(updatedDto), result);
        verify(creditService).update(creditId, TestUtils.buildGazprombankCreditDto());
    }

    @SneakyThrows
    @Test
    void getAllCredits() {
        List<CreditResponseDto> expectedList = List.of(TestUtils
                .toCreditResponseDto(TestUtils.buildGazprombankCredit()));

        when(creditService.getAll(any(CreditParams.class))).thenReturn(List.of(TestUtils.buildGazprombankCredit()));
        when(creditMapper.toCreditResponseDtos(anyList())).thenReturn(expectedList);

        String result = mockMvc.perform(get("/v1/credits"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(StandardCharsets.UTF_8);

        assertEquals(objectMapper.writeValueAsString(expectedList), result);
        verify(creditService).getAll(any(CreditParams.class));
    }

    @SneakyThrows
    @Test
    void getCreditById() {
        Long creditId = 1L;
        Credit credit = TestUtils.buildGazprombankCredit();
        CreditResponseDto expectedResponseDto = TestUtils.toCreditResponseDto(credit);

        when(creditService.getById(creditId)).thenReturn(credit);
        when(creditMapper.toCreditResponseDto(credit)).thenReturn(expectedResponseDto);

        String result = mockMvc.perform(get("/v1/credits/{creditId}", creditId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString(StandardCharsets.UTF_8);

        assertEquals(objectMapper.writeValueAsString(expectedResponseDto), result);
        verify(creditService).getById(creditId);
    }

    @SneakyThrows
    @Test
    void deleteCredit() {
        Long creditId = 1L;

        mockMvc.perform(delete("/v1/credits/{creditId}", creditId))
                .andDo(print())
                .andExpect(status().is(204));

        verify(creditService).delete(creditId);
    }

}
