package ru.cobp.backend.validation.constraints;

//@NotBlank(message = "Необоходимо указать цифровой код валюты")
//    @Pattern(regexp = "^[0-9]*$", message = "Цифровой код валюты состоит из символов от 0 до 9")
//    @Size(min = 3, max = 3, message = "Номер валюты должен состоять из 3 символов")


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import ru.cobp.backend.common.Constants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NotBlank(message = "{currency-num.blank.invalid}")
@Size.List({
        @Size(min = Constants.CURRENCY_NUM_LENGTH, message = "{currency-num.length.invalid}"),
        @Size(max = Constants.CURRENCY_NUM_LENGTH, message = "{currency-num.length.invalid}")
})
@Pattern(regexp = Constants.CURRENCY_NUM_REGEXP, message = "{currency-num.content.invalid}")
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface CurrencyNum {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
