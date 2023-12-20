package ru.cobp.backend.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.exception.deposit.DepositNotFoundException;
import ru.cobp.backend.exception.exchange.ExchangeRatesProcessingFailedException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtil {

    public static DepositNotFoundException getDepositNotFoundException() {
        return new DepositNotFoundException(ExceptionMessage.DEPOSIT_NOT_FOUND);
    }

    public static ExchangeRatesProcessingFailedException getExchangeRatesProcessingFailedException() {
        return new ExchangeRatesProcessingFailedException(ExceptionMessage.EXCHANGE_RATES_PROCESSING_FAILED);
    }

}
