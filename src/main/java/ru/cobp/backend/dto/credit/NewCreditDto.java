package ru.cobp.backend.dto.credit;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.model.credit.PaymentType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность нового кредита")
public class NewCreditDto {

    @NotBlank
    @Pattern(regexp = "^04\\d{7}$", message = "БИК должен состоять из 9 цифр")
    @Schema(description = "БИК банка")
    private String bankBic;

    @NotBlank
    @Size(min = 3, max = 100, message = "Название кредита должно содержать от 3 до 100 символов")
    @Pattern(regexp = "[а-яА-Я\", -]+", message = "Название кредита должно содержать только символы русского языка, " +
            "кавычки, дефис")
    @Schema(description = "Название кредита")
    private String name;

    @NotNull
    @Schema(description = "Доступность кредита")
    private Boolean isActive;

    @NotNull
    @Min(value = 0L, message = "Код валюты не может быть менее 1")
    @Max(value = 1000L, message = "Код валюты не может быть более 999")
    @Schema(description = "Код валюты")
    private Long currencyNum;

    @NotBlank
    @Size(min = 3, max = 100, message = "URL адресс продукта должен иметь от 3 до 100 символов")
    @Pattern(regexp = "^((http|https|ftp):\\/\\/)+[a-zA-Z./_0-9 -]+",
             message = "Некорректный URL-адрес продукта")
    @Schema(description = "Ссылка на кредит")
    private String productUrl;

    @NotNull
    @Min(value = 9999, message = "Минимальная сумма кредита не может быть менее 10000")
    @Max(value = 100000001, message = "Минимальная сумма кредита не может быть более 100000000")
    @Schema(description = "Минимальная сумма кредита")
    private Integer amountMin;

    @NotNull
    @Min(value = 9999, message = "Максимальная сумма кредита не может быть менее 10000")
    @Max(value = 100000001, message = "Максимальная сумма кредита не может быть более 100000000")
    @Schema(description = "Максимальная сумма кредита")
    private Integer amountMax;

    @NotNull
    @Positive(message = "Процентная ставка кредита не может быть менее 0")
    @Schema(description = "Процентная ставка кредита")
    private Double rate;

    @NotNull
    @Min(value = 3, message = "Срок кредита не может быть менее 3 месяцев")
    @Max(value = 120, message = "Срок кредита не может быть более 120 месяцев")
    @Schema(description = "Срок кредита")
    private Integer term;

    @NotNull
    @Schema(description = "Тип платежа")
    private PaymentType paymentType;

    @NotNull
    @Schema(description = "Получение без посещения банка")
    private Boolean creditOnline;

    @NotNull
    @Schema(description = "Подтверждение онлайн")
    private Boolean onlineApprove;

    @NotNull
    @Schema(description = "Наличие залога")
    private Boolean collateral;

}
