package ru.cobp.backend.dto.credit;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Сущность нового кредита")
public class NewCreditDto {

    @NotBlank
    private String banksBic;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    private Boolean isActive;

    @NotNull
    private Long currencyNum;

    @NotBlank
    @Size(min = 3, max = 100)
    private String productUrl;

    @NotNull
    @Positive
    private Integer minAmount;

    @NotNull
    @Positive
    private Integer maxAmount;

    @NotNull
    @Positive
    private Double rate;

    @NotNull
    @Positive
    private Integer term;

    @NotBlank
    @Schema(description = "Тип платежа")
    private String paymentType;

}
