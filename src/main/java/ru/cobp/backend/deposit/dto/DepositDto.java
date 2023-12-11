package ru.cobp.backend.deposit.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;
import ru.cobp.backend.bank.dto.BankDto;
import ru.cobp.backend.currency.dto.CurrencyDto;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность депозита")
public class DepositDto {
    @NotNull
    @Positive
    private Long id;

    @NotNull
    private BankDto bank;

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
    private List<RateDto> rates;
}
