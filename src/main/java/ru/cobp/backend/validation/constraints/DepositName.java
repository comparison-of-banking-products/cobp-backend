package ru.cobp.backend.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import ru.cobp.backend.common.Constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Size(max = Constants.DEPOSIT_NAME_MAX_LENGTH, message = "{deposit.name.length.invalid}")
@Pattern(regexp = Constants.DEPOSIT_NAME_REGEXP, message = "{deposit.name.content.invalid}")
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface DepositName {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
