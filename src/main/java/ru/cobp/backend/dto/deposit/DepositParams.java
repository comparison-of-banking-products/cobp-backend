package ru.cobp.backend.dto.deposit;

import java.util.List;

public record DepositParams(
        List<String> bics,
        Boolean isActive,
        Integer amountMin,
        Integer amountMax,
        Integer termMin,
        Integer termMax,
        Double rateMin,
        Double rateMax,
        Boolean capitalization,
        Boolean replenishment,
        Boolean partialWithdrawal,
        int page,
        int size
) {
}
