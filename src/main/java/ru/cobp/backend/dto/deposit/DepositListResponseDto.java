package ru.cobp.backend.dto.deposit;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

//todo change description

@Schema(description = "Список вкладов")
public record DepositListResponseDto(
        List<DepositResponseDto> deposits,
        long totalElements
) {
}
