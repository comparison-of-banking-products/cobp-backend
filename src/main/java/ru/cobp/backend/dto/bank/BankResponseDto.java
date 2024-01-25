package ru.cobp.backend.dto.bank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Полное представление банка")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankResponseDto {

    @Schema(description = "БИК, уникальный идентификатор банка в системе Центробанка")
    private String bic;

    @Schema(description = "Сокращенное название банка")
    private String name;

    @Schema(description = "Полное наименование банка с указанием организационно-правовой формы")
    private String legalEntity;

    @Schema(description = "Информация о банке")
    private String description;

    @Schema(description = "Логотип банка")
    private String logo;

    @Schema(description = "Наименование сайта банка")
    private String url;

}
