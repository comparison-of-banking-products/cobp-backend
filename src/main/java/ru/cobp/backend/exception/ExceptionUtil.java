package ru.cobp.backend.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtil {

    public static DepositNotFoundException getDepositNotFoundException() {
        return new DepositNotFoundException(ExceptionMessage.DEPOSIT_NOT_FOUND);
    }

    public static NotFoundException getBankNotFoundException(String bic) {
        return new NotFoundException(String.format(ExceptionMessage.BANK_NOT_FOUND, bic));
    }

    public static NotFoundException getCurrencyNotFoundException(String currencyNum) {
        return new NotFoundException(String.format(ExceptionMessage.CURRENCY_NOT_FOUND, currencyNum));
    }

    public static ExchangeRatesProcessingFailedException getExchangeRatesProcessingFailedException(Throwable cause) {
        return new ExchangeRatesProcessingFailedException(ExceptionMessage.EXCHANGE_RATES_PROCESSING_FAILED, cause);
    }

    public static LogoFileNotFoundException getLogoFileNotFoundException(String logoName) {
        return new LogoFileNotFoundException(
                String.format("%s [%s]", ExceptionMessage.LOGO_FILE_NOT_FOUND, logoName)
        );
    }

    public static LogoFileNotFoundException getLogoFileNotFoundException(String logoName, Throwable cause) {
        return new LogoFileNotFoundException(
                String.format("%s [%s]", ExceptionMessage.LOGO_FILE_NOT_FOUND, logoName), cause
        );
    }

    public static DepositNotFoundException getDepositNotFoundException(long depositId) {
        return new DepositNotFoundException(
                String.format("%s [depositId = %d]", ExceptionMessage.DEPOSIT_NOT_FOUND, depositId)
        );
    }

}
