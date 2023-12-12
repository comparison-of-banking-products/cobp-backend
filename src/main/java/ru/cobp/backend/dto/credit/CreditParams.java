package ru.cobp.backend.dto.credit;

import lombok.Value;

@Value
public class CreditParams {

    Boolean isActive;

    Integer currenciesNum;

    Integer minAmount;

    Integer maxAmount;

    Integer minRate;

    Integer minPeriod;

    Integer maxPeriod;

    Integer paymentTypeId;

    Boolean depositIsRequired;

    Boolean onlineApprove;

    Boolean onlineGetting;

    Boolean insurance;

}
