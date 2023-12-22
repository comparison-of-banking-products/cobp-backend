package ru.cobp.backend.dto.credit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность кредита")
public class CreditDto {

    @Schema(description = "Id кредита")
    private Long id;

    @Schema(description = "БИК банка")
    private Long banksBic;

    @Schema(description = "Название кредита")
    private String name;

    @Schema(description = "Доступность кредита")
    private Boolean isActive;

    @Schema(description = "Код валюты")
    private Long currencyNum;

    @Schema(description = "Ссылка на кредит")
    private String productUrl;

    @Schema(description = "Минимальная сумма кредита")
    private Integer minAmount;

    @Schema(description = "Максимальная сумма кредита")
    private Integer maxAmount;

    @Schema(description = "Процентная ставка кредита")
    private Double rate;

    @Schema(description = "Срок кредита")
    private Integer term;

}
