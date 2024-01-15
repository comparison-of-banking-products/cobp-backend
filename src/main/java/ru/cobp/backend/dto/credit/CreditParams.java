package ru.cobp.backend.dto.credit;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import ru.cobp.backend.model.credit.PaymentType;

@Value
@RequiredArgsConstructor
public class CreditParams {

    Boolean isActive;

    Long currencyNum;

    Integer minAmount;

    Integer maxAmount;

    Double rate;

    Integer minPeriod;

    Integer maxPeriod;

    PaymentType paymentType;

}
