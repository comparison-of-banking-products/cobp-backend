package ru.cobp.backend.calculator.controller;

import io.swagger.v3.oas.annotations.Operation;
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
import ru.cobp.backend.calculator.dto.AnnuityCreditCalculatorDto;
import ru.cobp.backend.calculator.dto.DifferentialCreditCalculatorDto;
import ru.cobp.backend.calculator.service.AnnuityCreditCalculator;
import ru.cobp.backend.calculator.service.DifferentialCreditCalculator;

@Tag(
        name = "Кредитный калькулятор",
        description = "Контроллер для работы с кредитным калькулятором"
)
@RestController
@RequestMapping(path = "/v1/calculators/credit")
@RequiredArgsConstructor
public class CreditCalculatorController {

    private final AnnuityCreditCalculator annuityCreditCalculator;

    private final DifferentialCreditCalculator differentialCreditCalculator;

    @Operation(
            summary = "Рассчитать аннуитетный кредит",
            description = "Конечная точка для расчета аннуитетного кредита с наинизшей ставкой"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Аннуитетный кредит рассчитан",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = AnnuityCreditCalculatorDto.class)
            )}
    )})
    @GetMapping("/annuity")
    public AnnuityCreditCalculatorDto calculateAnnuityCredit(
            @RequestParam @Positive int amount,
            @RequestParam @Positive int term
    ) {
        return annuityCreditCalculator.calculate(amount, term);
    }

    @Operation(
            summary = "Рассчитать дифференцированный кредит",
            description = "Конечная точка для расчета дифференцированного кредита с наинизшей ставкой"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Дифференцированный кредит рассчитан",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = DifferentialCreditCalculatorDto.class)
            )}
    )})
    @GetMapping("/differential")
    public DifferentialCreditCalculatorDto calculateDifferentialCredit(
            @RequestParam @Positive int amount,
            @RequestParam @Positive int term
    ) {
        return differentialCreditCalculator.calculate(amount, term);
    }

}
