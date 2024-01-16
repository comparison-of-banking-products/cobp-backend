package ru.cobp.backend.dto.credit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankResponseDto;
import ru.cobp.backend.dto.currency.CurrencyResponseDto;

@Schema(description = "Кредит")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditResponseDto {

    @Schema(description = "Id")
    private Long id;

    @Schema(description = "Банк")
    private BankResponseDto bank;

    @Schema(description = "Название")
    private String name;

    @Schema(description = "URL-адрес продукта")
    private String productUrl;

    @Schema(description = "Доступность")
    private Boolean isActive;

    @Schema(description = "Валюта")
    private CurrencyResponseDto currency;

    @Schema(description = "Минимальная сумма")
    private Integer amountMin;

    @Schema(description = "Максимальная сумма")
    private Integer amountMax;

    @Schema(description = "Срок кредита")
    private Integer term;

    @Schema(description = "Процентная ставка")
    private Double rate;

    @Schema(description = "Тип платежа")
    private String paymentType;

    @Schema(description = "Рассмотрение онлайн")
    private Boolean creditOnline;

    @Schema(description = "Подтверждение онлайн")
    private Boolean onlineApprove;

    @Schema(description = "Наличие залога")
    private Boolean collateral;

}
