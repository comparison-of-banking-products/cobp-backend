package ru.cobp.backend.dto.deposit;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cobp.backend.dto.currency.CurrencyDto;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность нового депозита")
public class NewDepositDto {

    @Positive
    @NotNull
    private Long banksBic;

    @NotBlank
    @Size(max = 100)
    @NotNull
    private String name;

    @NotBlank
    @Size(max = 100)
    @NotNull
    private String productUrl;

    @NotNull
    private Boolean isActive;

    @NotNull
    private CurrencyDto currency;

    @Positive
    @NotNull
    private Integer amountMin;

    @Positive
    @NotNull
    private Integer amountMax;

    @Positive
    @NotNull
    private Double rateMin;

    @Positive
    @NotNull
    private Double rateMax;

    @Positive
    @NotNull
    private Integer termMin;

    @Positive
    @NotNull
    private Integer termMax;

    @NotNull
    private Boolean capitalization;

    @NotNull
    private Boolean interestPayment;

    @NotNull
    private Boolean partialWithdrawal;

    @NotNull
    private Boolean replenishment;

}
