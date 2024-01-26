package ru.cobp.backend.common;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final int NUMBER_OF_MONTHS_IN_YEAR = 12;

    public static final int BIC_LENGTH = 9;

    public static final String ONLY_DIGITS_REGEXP = "\\d+";

    public static final String BANK_NAME_REGEXP = "^[а-яА-Я-\\s]*$";

    public static final String DESCRIPTION_REGEXP = "^[0-9a-zA-Zа-яёЁА-Я-@#$.,?%^&+=!\"'«»\\s]*$";

    public static final String LEGAL_ENTITY_REGEXP = "^[а-яА-Я-\"'«»\\s]*$";

    public static final String LOGO_REGEXP = "^[а-яА-Яa-zA-Z-.]*$";

    public static final String URL_REGEXP = "(http(s)?:\\/\\/.)?(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

    public static final int URL_MAX_LENGTH = 100;

    public static final int LOGO_MAX_LENGTH = 100;

    public static final int LEGAL_ENTITY_MAX_LENGTH = 100;

    public static final int BANK_NAME_MAX_LENGTH = 100;

    public static final int CURRENCY_NAME_MAX_LENGTH = 100;

    public static final int CODE_LENGTH = 3;

    public static final int DESCRIPTION_MAX_LENGTH = 100;

    public static final int CURRENCY_NUM_LENGTH = 3;

    public static final String CURRENCY_NUM_REGEXP = "^[0-9]*$";

    public static final String CURRENCY_CODE_REGEXP = "^[A-Z]*$";

    public static final String CURRENCY_NAME_REGEXP = "^[а-яА-Я\\s]*$";

    public static final int DEPOSIT_NAME_MAX_LENGTH = 100;

    public static final String DEPOSIT_NAME_REGEXP = "^[0-9a-zA-Zа-яёЁА-Я-@#$.,?%^&+=!\"'«»\\s]*$";

    public static final int DEPOSIT_AMOUNT_MIN = 10_000;

    public static final int DEPOSIT_AMOUNT_MAX = 100_000_000;

}
