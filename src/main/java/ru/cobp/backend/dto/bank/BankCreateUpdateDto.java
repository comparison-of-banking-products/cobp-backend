package ru.cobp.backend.dto.bank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cobp.backend.validation.constraints.Description;
import ru.cobp.backend.validation.constraints.BankName;
import ru.cobp.backend.validation.constraints.Bic;
import ru.cobp.backend.validation.constraints.LegalEntity;
import ru.cobp.backend.validation.constraints.Logo;
import ru.cobp.backend.validation.constraints.Url;

@Schema(description = "Данные для создания / обновления банка")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankCreateUpdateDto {

    @Schema(description = "БИК")
    @Bic
    private String bic;

    @Schema(description = "Сокращенное название банка")
    @BankName
    private String name;

    @Schema(description = "Полное наименование банка (юридическое лицо)")
    @LegalEntity
    private String legalEntity;

    @Schema(description = "Информация о банке")
    @Description
    private String description;

    @Schema(description = "Логотип банка")
    @Logo
    private String logo;

    @Schema(description = "Наименование сайта банка")
    @Url
    private String url;
}
