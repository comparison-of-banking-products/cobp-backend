package ru.cobp.backend.controller.calculator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cobp.backend.dto.calculator.DepositCalculatorResponse;
import ru.cobp.backend.service.calculator.DepositCalculatorService;

@Tag(
        name = "Депозитный калькулятор",
        description = "Контроллер для работы с депозитным калькулятором"
)
@RestController
@RequestMapping(path = "/v1/calculators/deposit")
@RequiredArgsConstructor
public class DepositCalculatorController {

    private final DepositCalculatorService depositCalculatorService;

    @Operation(
            summary = "Рассчитать депозит",
            description = "Конечная точка для расчета депозита с наивысшей доступной ставкой"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Депозит рассчитан",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = DepositCalculatorResponse.class)
            )}
    )})
    @GetMapping
    public DepositCalculatorResponse calculateDeposit() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
