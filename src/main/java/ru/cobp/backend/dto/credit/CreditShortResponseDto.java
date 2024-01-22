package ru.cobp.backend.dto.credit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankShortResponseDto;
import ru.cobp.backend.model.credit.PaymentType;

@Schema(description = "Краткое представление кредита")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditShortResponseDto {

    @Schema(description = "Банк")
    private BankShortResponseDto bank;

    @Schema(description = "Название")
    private String name;

    @Schema(description = "URL-адрес продукта")
    private String productUrl;

    @Schema(description = "Срок")
    private Integer term;

    @Schema(description = "Процентная ставка")
    private Double rate;

    @Schema(description = "Тип платежа")
    private PaymentType paymentType;

    @Schema(description = "Получение без посещения банка")
    private Boolean creditOnline;

    @Schema(description = "Подтверждение онлайн")
    private Boolean onlineApprove;

    @Schema(description = "Наличие залога")
    private Boolean collateral;

}
