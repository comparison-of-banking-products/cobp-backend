package ru.cobp.backend.dto.credit;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditDto {

    private Long id;

    private Long banksBic;

    private String name;

    private Boolean isActive;

    private Integer currenciesNum;

    private String productUrl;

    private Integer minAmount;

    private Integer maxAmount;

    private Float minRate;

    private Integer minPeriod;

    private Integer maxPeriod;

    private Integer paymentTypeId;

    private Boolean depositIsRequired;

    private Boolean onlineApprove;

    private Boolean onlineGetting;

    private Boolean insurance;

}
