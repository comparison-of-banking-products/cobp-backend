package ru.cobp.backend.dto.currency;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.cobp.backend.common.TestUtils;

import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyDtoValidationTest {
    static Validator validator;
    static CurrencyCreateUpdateDto createUpdateDto;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @BeforeEach
    void init() {
        createUpdateDto = TestUtils.buildCurrencyCreateUpdateDto();
    }

    @Test
    void testBankCreateUpdateDto_whenValid_thenNoValidationErrors() {
        // when
        Set<ConstraintViolation<CurrencyCreateUpdateDto>> violations = validator.validate(createUpdateDto);

        // then
        assertEquals(0, violations.size());
    }

    @Test
    void testBankCreateUpdateDto_whenInvalidParameters_throwValidationExceptions() {
        // given
        createUpdateDto.setCode("X_30");
        createUpdateDto.setCurrency("Canadian dollar");

        // when
        Set<ConstraintViolation<CurrencyCreateUpdateDto>> violations = validator.validate(createUpdateDto);

        Set<String> messages = violations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        // then
        assertEquals(3, violations.size());
        assertTrue(messages.contains("{currency-name.content.invalid}"));
        assertTrue(messages.contains("{currency-code.content.invalid}"));
        assertTrue(messages.contains("{currency-code.length.invalid}"));
    }

}