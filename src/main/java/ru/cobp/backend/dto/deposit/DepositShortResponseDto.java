package ru.cobp.backend.dto.deposit;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankShortResponseDto;

@Schema(description = "Краткое представление вклада")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositShortResponseDto {

    @Schema(description = "Банк")
    private BankShortResponseDto bank;

    @Schema(description = "Название")
    private String name;

    @Schema(description = "URL-адрес продукта")
    private String productUrl;

    @Schema(description = "Срок")
    private Integer term;

    @Schema(description = "Процентная ставка")
    private Double rate;

}
