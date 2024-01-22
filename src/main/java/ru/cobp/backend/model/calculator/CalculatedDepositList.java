package ru.cobp.backend.model.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CalculatedDepositList {

    private List<CalculatedDeposit> calculatedDeposits;

    private Long totalElements;

}
