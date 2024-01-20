package ru.cobp.backend.dto.calculator;

import java.util.List;

public record DepositCalculatorParams(
        int amount,
        int term,
        Boolean capitalization,
        Boolean replenishment,
        Boolean partialWithdrawal,
        List<String> bics,
        int page,
        int size
) {
}
