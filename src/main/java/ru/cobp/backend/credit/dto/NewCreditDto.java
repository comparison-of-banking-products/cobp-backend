package ru.cobp.backend.credit.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NewCreditDto {

    @NotNull
    private Long banksBic;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    private Boolean isActive;

    @NotNull
    @PositiveOrZero
    private Integer currenciesNum;

    @NotBlank
    @Size(min = 3, max = 100)
    private String productUrl;

    @NotNull
    @Positive
    private Integer minAmount;

    @NotNull
    @Positive
    private Integer maxAmount;

    @NotNull
    @Positive
    private Float minRate;

    @NotNull
    @Positive
    private Integer minPeriod;

    @NotNull
    @Positive
    private Integer maxPeriod;

    @NotNull
    @PositiveOrZero
    private Integer paymentTypeId;

    @NotNull
    private Boolean depositIsRequired;

    @NotNull
    private Boolean onlineApprove;

    @NotNull
    private Boolean onlineGetting;

    @NotNull
    private Boolean insurance;

}