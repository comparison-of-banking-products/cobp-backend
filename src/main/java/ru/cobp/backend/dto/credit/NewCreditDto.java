package ru.cobp.backend.dto.credit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.model.credit.PaymentType;
import ru.cobp.backend.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность нового кредита")
public class NewCreditDto {

    @BicNotBlank
    @Schema(description = "БИК банка")
    private String bankBic;

    @BankName
    @Schema(description = "Название кредита")
    private String name;

    @CreditIsActiveNotNull
    @Schema(description = "Доступность кредита")
    private Boolean isActive;

    @CurrencyNumNotBlank
    @Schema(description = "Код валюты")
    private String currencyNum;

    @UrlNotBlank
    @Schema(description = "Ссылка на кредит")
    private String productUrl;

    @AmountNotNull
    @Schema(description = "Минимальная сумма кредита")
    private Integer amountMin;

    @AmountNotNull
    @Schema(description = "Максимальная сумма кредита")
    private Integer amountMax;

    @RateNotNull
    @Schema(description = "Процентная ставка кредита")
    private Double rate;

    @CreditTermNotNull
    @Schema(description = "Срок кредита")
    private Integer term;

    @PaymentTypeNotNull
    @Schema(description = "Тип платежа")
    private PaymentType paymentType;

    @CreditOnlineNotNull
    @Schema(description = "Получение без посещения банка")
    private Boolean creditOnline;

    @OnlineApproveNotNull
    @Schema(description = "Подтверждение онлайн")
    private Boolean onlineApprove;

    @CollateralNotNull
    @Schema(description = "Наличие залога")
    private Boolean collateral;

}
