package ru.cobp.backend.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.exception.deposit.DepositNotFoundException;
import ru.cobp.backend.exception.exchange.ExchangeRatesProcessingFailedException;
import ru.cobp.backend.exception.storage.LogoFileNotFoundException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtil {

    public static DepositNotFoundException getDepositNotFoundException() {
        return new DepositNotFoundException(ExceptionMessage.DEPOSIT_NOT_FOUND);
    }

    public static ExchangeRatesProcessingFailedException getExchangeRatesProcessingFailedException(Throwable cause) {
        return new ExchangeRatesProcessingFailedException(ExceptionMessage.EXCHANGE_RATES_PROCESSING_FAILED, cause);
    }

    public static LogoFileNotFoundException getLogoFileNotFoundException(String logoName) {
        return new LogoFileNotFoundException(
                String.format("%s [%s]", ExceptionMessage.LOGO_FILE_NOT_FOUND, logoName)
        );
    }

}
