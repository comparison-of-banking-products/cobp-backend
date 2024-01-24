package ru.cobp.backend.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.cobp.backend.validation.constraints.BicLengthCon;

public class BicLengthValidator implements ConstraintValidator<BicLengthCon, String> {

    private static final int BIC_LENGTH = 9;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        return !s.isBlank() && s.length() == BIC_LENGTH;
    }

}
