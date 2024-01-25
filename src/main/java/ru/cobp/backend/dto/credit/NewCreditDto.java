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
    private String bankBic;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    private Boolean isActive;

    @NotNull
    private String currencyNum;

    @NotBlank
    @Size(min = 3, max = 100)
    private String productUrl;

    @NotNull
    @Positive
    private Integer amountMin;

    @NotNull
    @Positive
    private Integer amountMax;

    @NotNull
    @Positive
    private Double rate;

    @NotNull
    @Positive
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
