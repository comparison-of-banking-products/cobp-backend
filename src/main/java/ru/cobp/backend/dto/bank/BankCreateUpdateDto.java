package ru.cobp.backend.dto.bank;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankCreateUpdateDto {

    @Schema(description = "БИК")
    @NotNull(message = "Необходимо указать БИК банка")
    private String bic;

    @Schema(description = "Название")
    @NotNull(message = "Необходимо указать название банка")
    @Size(max = 100)
    private String name;

    @Schema(description = "Юридическое лицо")
    @NotNull(message = "Необходимо указать полное юридическое лицо")
    @Size(max = 100)
    private String legalEntity;

    @Schema(description = "Описание")
    @NotNull(message = "Необходимо указать описание банка")
    private String description;

    @Schema(description = "Лого")
    @NotNull(message = "Необходимо указать лого банка")
    @Size(max = 100)
    private String logo;

    @Schema(description = "Онлайн-адрес")
    @NotNull(message = "Необходимо указать онлайн-адрес банка")
    @Size(max = 100)
    private String url;
}
