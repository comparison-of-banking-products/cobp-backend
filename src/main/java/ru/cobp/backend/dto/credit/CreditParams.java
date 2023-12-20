package ru.cobp.backend.dto.credit;

import lombok.Value;

@Value
public class CreditParams {

    Boolean isActive;

    Long currencyNum;

    Integer minAmount;

    Integer maxAmount;

    Double rate;

    Integer minPeriod;

    Integer maxPeriod;

    String paymentType;

}
