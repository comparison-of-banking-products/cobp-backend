package ru.cobp.backend.controller.calculator;

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
import ru.cobp.backend.dto.calculator.DepositCalculatorDto;

@Tag(
        name = "Депозитный калькулятор",
        description = "Контроллер для работы с депозитным калькулятором"
)
@RestController
@RequestMapping(path = "/v1/calculators/deposit")
public class DepositCalculatorController {

    @Operation(
            summary = "Рассчитать депозит",
            description = "Конечная точка для расчета депозита с наивысшей доступной ставкой"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Депозит рассчитан",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = DepositCalculatorDto.class)
            )}
    )})
    @GetMapping
    public DepositCalculatorDto calculateDeposit() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
