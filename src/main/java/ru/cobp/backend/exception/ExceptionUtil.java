package ru.cobp.backend.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.exception.deposit.DepositNotFoundException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtil {

    public static DepositNotFoundException getDepositNotFoundException() {
        return new DepositNotFoundException(ExceptionMessage.DEPOSIT_NOT_FOUND);
    }

}
