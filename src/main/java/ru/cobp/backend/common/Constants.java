package ru.cobp.backend.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final int NUMBER_OF_MONTHS_IN_YEAR = 12;

    public static final int BIC_LENGTH = 9;

    public static final String ONLY_DIGITS_REGEXP = "\\d+";

    public static final String NAME_REGEXP = "^[а-яА-Я-\\s]*$";

    public static final String URL_REGEXP = "(http(s)?:\\/\\/.)?(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

    public static final int URL_MAX_LENGTH = 100;

    public static final int CURRENCY_NUM_LENGTH = 3;

    public static final String CURRENCY_NUM_REGEXP = "^[0-9]*$";

}
