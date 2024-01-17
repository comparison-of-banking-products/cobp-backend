package ru.cobp.backend.dto.calculator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "Результат расчета вкладов")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatedDepositListResponseDto {

    @Schema(description = "Список рассчитанных вкладов")
    private List<CalculatedDepositResponseDto> calculatedDeposits;

    @Schema(description = "Общее количество вкладов")
    private Long totalElements;

}
