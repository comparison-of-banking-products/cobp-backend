package ru.cobp.backend.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessage {

    public static final String DEPOSIT_NOT_FOUND = "Deposit not found";

    public static final String EXCHANGE_RATES_PROCESSING_FAILED = "Exchange rates processing failed";

    public static final String LOGO_FILE_NOT_FOUND = "Logo file not found";

    public static final String BANK_NOT_FOUND = "Bank with BIC %s not found";

    public static final String CURRENCY_NOT_FOUND = "Currency not found";

    public static final String DUPLICATE_EXCEPTION = "Object of type %s already exists";

}
