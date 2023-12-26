package ru.cobp.backend.dto.bank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Полное представление банка")
@Data
@NoArgsConstructor
public class BankResponseDto {

    @Schema(description = "БИК")
    private Long bic;

    @Schema(description = "Название")
    private String name;

    @Schema(description = "Юридическое лицо")
    private String legalEntity;

    @Schema(description = "Описание")
    private String description;

    @Schema(description = "Лого")
    private String logo;

    @Schema(description = "Онлайн-адрес")
    private String url;

}
