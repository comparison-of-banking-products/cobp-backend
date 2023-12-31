package ru.cobp.backend.dto.bank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Краткое представление банка")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankShortResponseDto {

    @Schema(description = "Название банка")
    private String name;

    @Schema(description = "Лого банка")
    private String logo;

}
