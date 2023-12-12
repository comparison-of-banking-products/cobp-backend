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
import ru.cobp.backend.dto.calculator.AnnuityCreditCalculatorResponse;
import ru.cobp.backend.dto.calculator.DifferentialCreditCalculatorResponse;
import ru.cobp.backend.service.calculator.CreditCalculatorService;

@Tag(
        name = "Кредитный калькулятор",
        description = "Контроллер для работы с кредитным калькулятором"
)
@RestController
@RequestMapping(path = "/v1/calculators/credit")
@RequiredArgsConstructor
public class CreditCalculatorController {

    private final CreditCalculatorService creditCalculator;

    @Operation(
            summary = "Рассчитать аннуитетный кредит",
            description = "Конечная точка для расчета аннуитетного кредита с наинизшей доступной ставкой"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Аннуитетный кредит рассчитан",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnnuityCreditCalculatorResponse.class)
            )}
    )})
    @GetMapping("/annuity")
    public AnnuityCreditCalculatorResponse calculateAnnuityCredit(
            @Parameter(description = "Сумма кредита")
            @RequestParam @Positive int amount,

            @Parameter(description = "Срок кредита в месяцах")
            @RequestParam @Positive int term
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Operation(
            summary = "Рассчитать дифференцированный кредит",
            description = "Конечная точка для расчета дифференцированного кредита с наинизшей доступной ставкой"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Дифференцированный кредит рассчитан",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = DifferentialCreditCalculatorResponse.class)
            )}
    )})
    @GetMapping("/differential")
    public DifferentialCreditCalculatorResponse calculateDifferentialCredit(
            @Parameter(description = "Сумма кредита")
            @RequestParam @Positive int amount,

            @Parameter(description = "Срок кредита в месяцах")
            @RequestParam @Positive int term
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
