package ru.cobp.backend.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.cobp.backend.validation.validator.BicLengthValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BicLengthValidator.class)
public @interface BicLengthCon {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
