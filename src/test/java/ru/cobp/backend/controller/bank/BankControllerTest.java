package ru.cobp.backend.controller.bank;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.cobp.backend.dto.bank.BankCreateUpdateDto;
import ru.cobp.backend.dto.bank.BankResponseDto;
import ru.cobp.backend.dto.bank.BankSort;
import ru.cobp.backend.exception.DuplicateException;
import ru.cobp.backend.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class BankControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    static BankCreateUpdateDto createUpdateDto;
    static List<String> bics = List.of("044525111", "044525187", "044525225", "044525593", "044525823", "044525974");

    static Stream<Arguments> banksSearchInputsForParameterisedTest() {
        return Stream.of(
                Arguments.of(BankSort.DEPOSITS, List.of("044525187", "044525823", "044525974")),
                Arguments.of(BankSort.CREDITS, bics)
        );
    }

    @BeforeEach
    void init() {
        createUpdateDto = BankCreateUpdateDto.builder()
                .bic("123456789")
                .name("bank name")
                .description("description")
                .legalEntity("legal entity")
                .logo("logo.svg")
                .url("https://url.com")
                .build();
    }

    @Test
    void create_whenValidCreateDto_shouldAddNewBank() {
        // given
        BankResponseDto expect = createBank(createUpdateDto);

        // when
        BankResponseDto actual = getBankByBic(createUpdateDto.getBic());

        // then
        compareExpectAndActualBankResponseDtos(expect, actual);
    }

    @Test
    @SneakyThrows
    void create_whenBicNotUnique_throwDuplicateException() {
        // given
        createUpdateDto.setBic("044525111");

        // then
        mockMvc.perform(post("/v1/banks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUpdateDto)))
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof DuplicateException));
    }

    @Test
    void update_whenValidUpdateDto_thenReturnUpdatedResponse() {
        // given
        createUpdateDto.setBic("044525111");
        BankResponseDto expect = updateBank(createUpdateDto.getBic(), createUpdateDto);

        // when
        BankResponseDto actual = getBankByBic(createUpdateDto.getBic());

        // then
        compareExpectAndActualBankResponseDtos(expect, actual);
    }

    @Test
    @SneakyThrows
    void update_whenBicInvalid_throwNotFoundException() {
        // given
        String invalidBic = "123456789";

        // then
        mockMvc.perform(put("/v1/banks/{bic}", invalidBic)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUpdateDto)))
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof NotFoundException));
    }

    @Test
    @SneakyThrows
    void getByBic_whenBicInvalid_throwNotFoundException() {
        // given
        String invalidBic = "123456789";

        // then
        mockMvc.perform(get("/v1/banks/{bic}", invalidBic)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof NotFoundException));
    }

    @Test
    @SneakyThrows
    void delete_whenBicInvalid_throwNotFoundException() {
        // given
        String invalidBic = "123456789";

        // then
        mockMvc.perform(delete("/v1/banks/{bic}", invalidBic)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertTrue(result.getResolvedException()
                        instanceof NotFoundException));
    }

    @ParameterizedTest
    @MethodSource("banksSearchInputsForParameterisedTest")
    @SneakyThrows
    void getAll_whenSearch_thenReturnBanks(BankSort sort, List<String> expectedBics) {
        // given
        List<BankResponseDto> expected = getBanksByBics(expectedBics);

        // when
        List<BankResponseDto> actual = getBanksBySortParameter(sort);

        // then
        performAssertions(expected, actual);
    }

    List<BankResponseDto> getBanksByBics(List<String> bics) {
        List<BankResponseDto> banks = new ArrayList<>();
        for (String bic : bics) banks.add(getBankByBic(bic));
        return banks;
    }

    @SneakyThrows
    List<BankResponseDto> getBanksBySortParameter(BankSort sort) {
        MvcResult result = mockMvc.perform(get("/v1/banks")
                        .param("sort", String.valueOf(sort))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        return List.of(objectMapper.readValue(
                result.getResponse().getContentAsString(),
                BankResponseDto[].class));
    }

    @SneakyThrows
    BankResponseDto getBankByBic(String bic) {
        MvcResult result = mockMvc.perform(get("/v1/banks/{bic}", bic)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        return objectMapper.readValue(
                result.getResponse().getContentAsString(),
                BankResponseDto.class);
    }

    void performAssertions(List<BankResponseDto> expect, List<BankResponseDto> actual) {
        assertEquals(expect.size(), actual.size());

        for (int i = 0; i < expect.size(); i++) {
            BankResponseDto expectBank = expect.get(i);
            BankResponseDto actualBank = actual.get(i);
            compareExpectAndActualBankResponseDtos(expectBank, actualBank);
        }
    }

    void compareExpectAndActualBankResponseDtos(BankResponseDto expectBank, BankResponseDto actualBank) {
        assertEquals(expectBank.getBic(), actualBank.getBic());
        assertEquals(expectBank.getName(), actualBank.getName());
        assertEquals(expectBank.getDescription(), actualBank.getDescription());
        assertEquals(expectBank.getLegalEntity(), actualBank.getLegalEntity());
        assertEquals(expectBank.getLogo(), actualBank.getLogo());
        assertEquals(expectBank.getUrl(), actualBank.getUrl());
    }

    @SneakyThrows
    BankResponseDto createBank(BankCreateUpdateDto createUpdateDto) {
        MvcResult result = mockMvc.perform(post("/v1/banks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUpdateDto)))
                .andExpect(status().isCreated())
                .andReturn();

        return objectMapper.readValue(
                result.getResponse().getContentAsString(),
                BankResponseDto.class);
    }

    @SneakyThrows
    BankResponseDto updateBank(String bic, BankCreateUpdateDto createUpdateDto) {
        MvcResult result = mockMvc.perform(put("/v1/banks/{bic}", bic)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createUpdateDto)))
                .andExpect(status().isOk())
                .andReturn();

        return objectMapper.readValue(
                result.getResponse().getContentAsString(),
                BankResponseDto.class);
    }
}