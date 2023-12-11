package ru.cobp.backend.depositrate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import ru.cobp.backend.deposit.entity.Deposit;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность процентной ставки депозита")
public class DepositRateDto {
    private Long id;
    private Deposit deposit;
    private Integer amountMin;
    private Integer amountMax;
    private Double rate;
    private Integer termMin;
    private Integer termMax;
}
