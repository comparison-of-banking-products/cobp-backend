package ru.cobp.backend.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.cobp.backend.validation.constraints.BicOnlyDigitsCon;

import java.util.regex.Pattern;

public class BicOnlyDigitsValidator implements ConstraintValidator<BicOnlyDigitsCon, String> {

    private static final Pattern ONLY_DIGITS_PATTERN = Pattern.compile("\\d+");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        return ONLY_DIGITS_PATTERN.matcher(s).matches();
    }

}
