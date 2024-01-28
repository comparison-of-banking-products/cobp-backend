package ru.cobp.backend.model.deposit;

public record DepositPatch(
        Boolean isActive,
        Integer amountMin,
        Integer amountMax,
        Integer term,
        Double rate,
        Boolean capitalization,
        Boolean replenishment,
        Boolean partialWithdrawal
) {
}
