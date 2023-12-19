package ru.cobp.backend.dto.credit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankShortResponseDto;

@Schema(description = "Краткое представление кредита")
@Data
@NoArgsConstructor
public class CreditShortResponseDto {

    @Schema(description = "Банк")
    private BankShortResponseDto bank;

    @Schema(description = "Название кредита")
    private String creditName;

    @Schema(description = "Ссылка на кредит")
    private String creditUrl;

    @Schema(description = "Срок кредита")
    private Integer term;

    @Schema(description = "Процентная ставка кредита")
    private Double rate;

}
