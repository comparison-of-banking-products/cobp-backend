package ru.cobp.backend.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final int NUMBER_OF_MONTHS_IN_YEAR = 12;

    public static final int BIC_LENGTH = 9;

    public static final String ONLY_DIGITS_REGEXP = "\\d+";

    public static final String NAME_REGEXP = "^[а-яА-Я-\\s]*$";

}
