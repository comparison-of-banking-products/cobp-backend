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
import ru.cobp.backend.dto.calculator.CreditCalculatorMapper;
import ru.cobp.backend.dto.calculator.CreditCalculatorResponse;
import ru.cobp.backend.model.calculator.CreditCalculator;
import ru.cobp.backend.service.calculator.CreditCalculatorService;

@Tag(
        name = "Кредитный калькулятор",
        description = "Контроллер для работы с кредитным калькулятором"
)
@RestController
@RequestMapping(path = "/v1/calculators/credit")
@RequiredArgsConstructor
public class CreditCalculatorController {

    private final CreditCalculatorService creditCalculatorService;

    @Operation(
            summary = "Рассчитать кредит",
            description = "Конечная точка для расчета кредита с наинизшей доступной ставкой"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Кредит рассчитан",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CreditCalculatorResponse.class)
            )}
    )})
    @GetMapping
    public CreditCalculatorResponse calculateCredit(
            @Parameter(description = "Сумма кредита в рублях")
            @RequestParam @Positive int amount,

            @Parameter(description = "Срок кредита в месяцах")
            @RequestParam @Positive int term
    ) {
        CreditCalculator cc = creditCalculatorService.calculateMinimumRateAnnuityCredit(amount, term);

        return CreditCalculatorMapper.toResponse(cc);
    }

}
