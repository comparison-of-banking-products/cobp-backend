package ru.cobp.backend.dto.calculator;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Результат расчета аннуитетного кредита")
@Data
@NoArgsConstructor
public class AnnuityCreditCalculatorResponse {
}
