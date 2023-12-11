package ru.cobp.backend.deposit.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.cobp.backend.bank.entity.Bank;
import ru.cobp.backend.currency.entity.Currency;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность нового депозита")
public class NewDepositDto {
    private Bank bank;
    private String name;
    private String productUrl;
    private Boolean isActive;
    private Currency currency;
    private Integer amountMin;
    private Integer amountMax;
    private Double rateMin;
    private Double rateMax;
    private Integer termMin;
    private Integer termMax;
    private Boolean capitalization;
    private Boolean interestPayment;
    private Boolean partialWithdrawal;
    private Boolean replenishment;
}
