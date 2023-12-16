package ru.cobp.backend.controller.calculator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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
import ru.cobp.backend.dto.calculator.CalculatedDepositResponseDto;
import ru.cobp.backend.dto.calculator.DepositCalculatorMapper;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
import ru.cobp.backend.service.calculator.DepositCalculatorService;

import java.util.List;

@Tag(
        name = "Депозитный калькулятор",
        description = "Контроллер для работы с депозитным калькулятором"
)
@RestController
@RequestMapping(path = "/v1/calculators")
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
                    schema = @Schema(implementation = CalculatedDepositResponseDto.class)
            )}
    )})
    @GetMapping("/deposit")
    public CalculatedDepositResponseDto calcMaximumRateDeposit(
            @Parameter(description = "Сумма вклада в рублях")
            @RequestParam @Positive int amount,

            @Parameter(description = "Срок вклада в месяцах")
            @RequestParam @Positive int term
    ) {
        CalculatedDeposit cd = depositCalculatorService.getMaximumRateCalculatedDeposit(amount, term);
        return DepositCalculatorMapper.toDto(cd);
    }

    @Operation(
            summary = "Рассчитать депозиты",
            description = "Конечная точка для расчета депозитов"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Депозиты рассчитаны",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(
                            schema = @Schema(implementation = CalculatedDepositResponseDto.class)
                    )
            )}
    )})
    @GetMapping("/deposits")
    public List<CalculatedDepositResponseDto> calcAllDeposits(
            @Parameter(description = "Сумма вклада в рублях")
            @RequestParam @Positive int amount,

            @Parameter(description = "Срок вклада в месяцах")
            @RequestParam @Positive int term,

            @Parameter(description = "Максимальная ставка")
            @RequestParam @Positive double rate
    ) {
        List<CalculatedDeposit> cds = depositCalculatorService.getCalculatedDeposits(amount, term, rate);
        return DepositCalculatorMapper.toDtos(cds);
    }

}
