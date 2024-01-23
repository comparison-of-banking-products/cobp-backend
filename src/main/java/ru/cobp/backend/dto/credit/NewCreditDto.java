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
    @Schema(description = "БИК банка")
    private String bankBic;

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
    private Integer amountMin;

    @NotNull
    @Positive
    @Schema(description = "Максимальная сумма кредита")
    private Integer amountMax;

    @NotNull
    @Positive
    @Schema(description = "Процентная ставка кредита")
    private Double rate;

    @NotNull
    @Positive
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
