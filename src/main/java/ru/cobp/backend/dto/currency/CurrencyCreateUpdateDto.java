package ru.cobp.backend.dto.currency;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Данные для создания / обновления валюты")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyCreateUpdateDto {

    @Schema(description = "Цифровой код валюты согласно общероссийскому классификатору валют")
    @NotBlank(message = "Необоходимо указать цифровой код валюты")
    @Pattern(regexp = "^[0-9]*$", message = "Цифровой код валюты состоит из символов от 0 до 9")
    @Size(min = 3, max = 3, message = "Номер валюты должен состоять из 3 символов")
    private String num;

    @Schema(description = "Буквенный код валюты согласно общероссийскому классификатору валют")
    @NotBlank(message = "Необоходимо указать буквенный код валюты")
    @Pattern(regexp = "^[A-Z]*$", message = "Буквенный код валюты состоит из символов латинского алфавита")
    @Size(min = 3, max = 3, message = "Буквенный код валюты должен состоять из 3 символов")
    private String code;

    @Schema(description = "Наименование валюты")
    @NotBlank(message = "Необходимо указать наименование валюты")
    @Pattern(regexp = "^[а-яА-Я\\s]*$", message = "Наименование валюты содержит только русские буквы и пробелы")
    @Size(max = 100, message = "Максимальная длина наименования валюты 100 символов")
    private String currency;
}
