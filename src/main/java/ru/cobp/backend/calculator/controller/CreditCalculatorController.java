package ru.cobp.backend.calculator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cobp.backend.credit.dto.CreditDto;

@Tag(
        name = "Кредитный калькулятор",
        description = "Контроллер для работы с кредитным калькулятором"
)
@RestController
@RequestMapping(path = "/v1/calculators/credit")
public class CreditCalculatorController {

    @Operation(
            summary = "Найти кредит",
            description = "Конечная точка для поиска кредита с наинизшей ставкой"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Кредит найден",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CreditDto.class)
            )}
    )})
    @GetMapping
    public void getCredit() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
