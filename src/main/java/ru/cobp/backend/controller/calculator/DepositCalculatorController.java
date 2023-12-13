package ru.cobp.backend.controller.calculator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.cobp.backend.dto.calculator.DepositCalculatorMapper;
import ru.cobp.backend.dto.calculator.DepositCalculatorResponse;
import ru.cobp.backend.service.calculator.DepositCalculatorService;
import ru.cobp.backend.service.calculator.impl.DepositCalculator;

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
    public DepositCalculatorResponse calculateDeposit(
            @Parameter(description = "Сумма вклада в рублях")
            @RequestParam @Positive int amount,

            @Parameter(description = "Срок вклада в месяцах")
            @RequestParam @Positive int term
    ) {
        DepositCalculator dc = depositCalculatorService.calculateMaximumRateDeposit(amount, term);

        return DepositCalculatorMapper.toResponse(dc);
    }

}
