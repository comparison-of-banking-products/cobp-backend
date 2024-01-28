package ru.cobp.backend.dto.deposit;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Список вкладов")
public record DepositListResponseDto(

        @Schema(description = "Вклады")
        List<DepositResponseDto> deposits,

        @Schema(description = "Общее количество вкладов")
        long totalElements

) {
}
