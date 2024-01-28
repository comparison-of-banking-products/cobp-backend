package ru.cobp.backend.dto.credit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.model.credit.PaymentType;
import ru.cobp.backend.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность кредита")
public class CreditUpdateDto {

    @CreditName
    @Schema(description = "Название кредита")
    private String name;

    @Schema(description = "Доступность кредита")
    private Boolean isActive;

    @Url
    @Schema(description = "Ссылка на кредит")
    private String productUrl;

    @Amount
    @Schema(description = "Минимальная сумма кредита")
    private Integer amountMin;

    @Amount
    @Schema(description = "Максимальная сумма кредита")
    private Integer amountMax;

    @Rate
    @Schema(description = "Процентная ставка кредита")
    private Double rate;

    @CreditTerm
    @Schema(description = "Срок кредита")
    private Integer term;

    @Schema(description = "Тип платежа")
    private PaymentType paymentType;

    @Schema(description = "Получение без посещения банка")
    private Boolean creditOnline;

    @Schema(description = "Подтверждение онлайн")
    private Boolean onlineApprove;

    @Schema(description = "Наличие залога")
    private Boolean collateral;

}
