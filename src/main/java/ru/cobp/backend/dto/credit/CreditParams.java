package ru.cobp.backend.dto.credit;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import ru.cobp.backend.model.credit.PaymentType;

import java.util.List;

@Value
@RequiredArgsConstructor
public class CreditParams {

    Boolean isActive;

    Long currencyNum;

    Integer amountMin;

    Integer amountMax;

    Double rate;

    Integer minPeriod;

    Integer maxPeriod;

    PaymentType paymentType;

    Boolean creditOnline;

    Boolean onlineApprove;

    Boolean collateral;

    List<String> banksBic;

}
