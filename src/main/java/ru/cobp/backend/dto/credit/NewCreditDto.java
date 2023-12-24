package ru.cobp.backend.dto.credit;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(description = "Сущность нового кредита")
public class NewCreditDto {

    @NotNull
    @Schema(description = "БИК банка")
    private Long banksBic;

    @NotBlank
    @Size(min = 3, max = 100)
    @Schema(description = "Название кредита")
    private String name;

    @NotNull
    @Schema(description = "Доступность кредита")
    private Boolean isActive;

    @NotNull
    @Schema(description = "Код валюты")
    private Long currencyNum;

    @NotBlank
    @Size(min = 3, max = 100)
    @Schema(description = "Ссылка на кредит")
    private String productUrl;

    @NotNull
    @Positive
    @Schema(description = "Минимальная сумма кредита")
    private Integer minAmount;

    @NotNull
    @Positive
    @Schema(description = "Максимальная сумма кредита")
    private Integer maxAmount;

    @NotNull
    @Positive
    @Schema(description = "Процентная ставка кредита")
    private Double rate;

    @NotNull
    @Positive
    @Schema(description = "Срок кредита")
    private Integer term;

    @NotNull
    @Schema(description = "Тип платежа по кредиту")
    private String paymentType;

}
