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
import ru.cobp.backend.calculator.dto.CalculatorDepositDto;
import ru.cobp.backend.deposit.dto.DepositDto;

@Tag(
        name = "Депозитный калькулятор",
        description = "Контроллер для работы с депозитным калькулятором"
)
@RestController
@RequestMapping(path = "/v1/calculators/deposit")
public class DepositCalculatorController {

    @Operation(
            summary = "Посчитать депозит",
            description = "Конечная точка для расчета депозита с наивысшей доступной ставкой"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Депозит найден",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = DepositDto.class)
            )}
    )})
    @GetMapping
    public CalculatorDepositDto get() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
