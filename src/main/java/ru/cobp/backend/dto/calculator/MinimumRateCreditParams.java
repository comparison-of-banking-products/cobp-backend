package ru.cobp.backend.dto.calculator;

import java.util.List;

public record MinimumRateCreditParams(
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
