package ru.cobp.backend.dto.calculator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "Результат расчета кредитов")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatedCreditListResponseDto {

    @Schema(description = "Список рассчитанных кредитов")
    private List<CalculatedCreditResponseDto> calculatedCredits;

    @Schema(description = "Общее количество кредитов")
    private Long totalElements;

}
