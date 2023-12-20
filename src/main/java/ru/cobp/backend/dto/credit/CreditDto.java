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

    private Long id;

    private Long banksBic;

    private String name;

    private Boolean isActive;

    private Long currencyNum;

    private String productUrl;

    private Integer minAmount;

    private Integer maxAmount;

    private Double rate;

    private Integer term;

    private String paymentType;

}
