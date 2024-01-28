package ru.cobp.backend.dto.currency;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cobp.backend.validation.constraints.Code;
import ru.cobp.backend.validation.constraints.CurrencyName;
import ru.cobp.backend.validation.constraints.CurrencyNum;

@Schema(description = "Данные для создания / обновления валюты")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyCreateUpdateDto {

    @Schema(description = "Цифровой код валюты")
    @CurrencyNum
    private String num;

    @Schema(description = "Буквенный код валюты")
    @Code
    private String code;

    @Schema(description = "Наименование валюты")
    @CurrencyName
    private String currency;
}
