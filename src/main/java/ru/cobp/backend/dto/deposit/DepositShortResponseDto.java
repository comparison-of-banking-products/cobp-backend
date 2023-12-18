package ru.cobp.backend.dto.deposit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankShortResponseDto;

@Schema(description = "Краткое представление вклада")
@Data
@NoArgsConstructor
public class DepositShortResponseDto {

    @Schema(description = "Банк")
    private BankShortResponseDto bank;

    @Schema(description = "Название вклада")
    private String depositName;

    @Schema(description = "Ссылка на вклад")
    private String depositUrl;

    @Schema(description = "Срок вклада")
    private Integer term;

    @Schema(description = "Процентная ставка вклада")
    private Double rate;

}
