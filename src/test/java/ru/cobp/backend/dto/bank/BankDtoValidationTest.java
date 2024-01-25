package ru.cobp.backend.dto.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ValidatorFactory;
import jakarta.validation.Validator;
import jakarta.validation.Validation;
import jakarta.validation.ConstraintViolation;
import ru.cobp.backend.common.TestUtils;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BankDtoValidationTest {
    static Validator validator;
    static BankCreateUpdateDto createUpdateDto;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @BeforeEach
    void init() {
        createUpdateDto = TestUtils.buildBankCreateUpdateDto();
    }

    @Test
    void testBankCreateUpdateDto_whenValid_thenNoValidationErrors() {
        // when
        Set<ConstraintViolation<BankCreateUpdateDto>> violations = validator.validate(createUpdateDto);

        // then
        assertEquals(0, violations.size());
    }

    @Test
    void testBankCreateUpdateDto_whenInvalidParameters_throwValidationExceptions() {
        // given
        createUpdateDto.setBic("123456A");  // BIC 6 digits & 1 letter
        createUpdateDto.setName("XYZ");     // english letters
        createUpdateDto.setDescription(""); // empty description

        // when
        Set<ConstraintViolation<BankCreateUpdateDto>> violations = validator.validate(createUpdateDto);

        Set<String> messages = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        // then
        assertEquals(4, violations.size());
        assertTrue(messages.contains("БИК должен состоять из чисел от 0 до 9"));
        assertTrue(messages.contains("БИК должен состоять из 9 символов"));
        assertTrue(messages.contains("Название может состоять из символов русского алфавита, дефиса"));
        assertTrue(messages.contains("Необходимо указать описание банка"));
    }

}