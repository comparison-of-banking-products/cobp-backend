package ru.cobp.backend.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.cobp.backend.validation.constraints.BicLength;

public class BicLengthValidator implements ConstraintValidator<BicLength, String> {

    private static final int BIC_LENGTH = 9;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        return !s.isBlank() && s.length() == BIC_LENGTH;
    }

}
