package ru.cobp.backend.model.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepositCalculator {

    private Long depositId;

    private Double rate;

    private Double annualProfit;

    private Double maturityProfit;

}
