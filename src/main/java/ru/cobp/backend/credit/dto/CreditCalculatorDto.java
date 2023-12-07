package ru.cobp.backend.credit.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditCalculatorDto {

    private Long id;

    private Long banksBic;

    private String name;

    private String productUrl;

    private Double loanPayment;

    private Float rate;

    private Integer paymentTypeId;

    private Boolean depositIsRequired;

    private Boolean onlineApprove;

    private Boolean onlineGetting;

    private Boolean insurance;

}