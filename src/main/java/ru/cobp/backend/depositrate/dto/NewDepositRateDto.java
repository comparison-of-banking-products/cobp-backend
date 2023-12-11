package ru.cobp.backend.depositrate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import ru.cobp.backend.deposit.entity.Deposit;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность новой процентной ставки депозита")
public class NewDepositRateDto {
    private Deposit deposit;
    private Integer amountMin;
    private Integer amountMax;
    private Double rate;
    private Integer termMin;
    private Integer termMax;
}
