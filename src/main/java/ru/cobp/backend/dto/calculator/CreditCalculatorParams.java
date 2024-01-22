package ru.cobp.backend.dto.calculator;

import java.util.List;

public record CreditCalculatorParams(
        int amount,
        int term,
        Boolean creditOnline,
        Boolean onlineApprove,
        Boolean collateral,
        List<String> bics,
        int page,
        int size
) {
}
