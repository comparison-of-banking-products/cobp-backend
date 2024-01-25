package ru.cobp.backend.dto.bank;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Данные для создания / обновления банка")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankCreateUpdateDto {

    @Schema(description = "БИК, уникальный идентификатор банка в системе Центробанка")
    @NotBlank(message = "Необходимо указать БИК банка")
    @Pattern(regexp = "[0-9]*$", message = "БИК должен состоять из чисел от 0 до 9")
    @Size(min = 9, max = 9, message = "БИК должен состоять из 9 символов")
    private String bic;

    @Schema(description = "Сокращенное название банка")
    @NotBlank(message = "Необходимо указать сокращенное название банка")
    @Pattern(regexp = "^[а-яА-Я-\\s]*$", message = "Название может состоять из символов русского алфавита, дефиса")
    @Size(max = 100, message = "Максимальная длина названия 100 символов")
    private String name;

    @Schema(description = "Полное наименование банка (юридическое лицо)")
    @NotBlank(message = "Необходимо указать полное юридическое лицо")
    @Pattern(regexp = "^[а-яА-Я-\"'«»\\s]*$",
            message = "Юридическое лицо банка может состоять из символов русского алфавита, дефиса, кавычек")
    @Size(max = 100, message = "Максимальная длина юридического лица 100 символов")
    private String legalEntity;

    @Schema(description = "Информация о банке")
    @NotBlank(message = "Необходимо указать описание банка")
    @Pattern(regexp = "^[0-9a-zA-Zа-яёЁА-Я-@#$.,?%^&+=!\"'«»\\s]*$",
            message = "Описание банка может содержать только символьно-числовые значения")
    @Size(max = 1000, message = "Максимальная длина описания 1000 символов")
    private String description;

    @Schema(description = "Логотип банка")
    @NotBlank(message = "Необходимо указать ссылку на файл")
    @Size(max = 1000, message = "Максимальная длина ссылки на файл 1000 символов")
    private String logo;

    @Schema(description = "Наименование сайта банка")
    @NotBlank(message = "Необходимо указать сайт банка")
    @Size(max = 100, message = "Максимальная длина сайта 100 символов")
    private String url;
}
