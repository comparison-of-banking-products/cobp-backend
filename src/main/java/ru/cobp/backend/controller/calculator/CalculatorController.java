package ru.cobp.backend.controller.calculator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.cobp.backend.dto.calculator.CalculatedCreditListResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedDepositListResponseDto;
import ru.cobp.backend.dto.calculator.MaximumRateDepositParams;
import ru.cobp.backend.dto.calculator.MinimumRateCreditParams;
import ru.cobp.backend.mapper.CalculatorMapper;
import ru.cobp.backend.model.calculator.CalculatedCreditList;
import ru.cobp.backend.model.calculator.CalculatedDepositList;
import ru.cobp.backend.service.calculator.CalculatorService;
import ru.cobp.backend.validation.constraints.Amount;
import ru.cobp.backend.validation.constraints.Bic;
import ru.cobp.backend.validation.constraints.PageIndex;
import ru.cobp.backend.validation.constraints.PageSize;
import ru.cobp.backend.validation.constraints.Term;

import java.util.List;

@Tag(
        name = "Калькуляторы вклада и кредита",
        description = "Контроллер для работы с калькуляторами вклада и кредита"
)
@RestController
@RequestMapping(path = "/v1/calculators")
@Validated
@RequiredArgsConstructor
public class CalculatorController {

    private final CalculatorService calculatorService;

    private final CalculatorMapper calculatorMapper;

    @Operation(
            summary = "Рассчитать вклады",
            description = "Конечная точка для расчета вкладов с наивысшей доступной ставкой"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Вклады рассчитаны",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CalculatedDepositListResponseDto.class)
            )}
    )})
    @GetMapping("/deposits")
    public CalculatedDepositListResponseDto getAllCalculatedDeposits(
            @Parameter(description = "Сумма вклада в рублях")
            @RequestParam @Amount int amount,

            @Parameter(description = "Срок вклада в месяцах")
            @RequestParam @Term int term,

            @Parameter(description = "Вклад с капитализацией")
            @RequestParam(required = false) Boolean capitalization,

            @Parameter(description = "Вклад с пополнением")
            @RequestParam(required = false) Boolean replenishment,

            @Parameter(description = "Вклад с частичным снятием")
            @RequestParam(required = false) Boolean partialWithdrawal,

            @Parameter(description = "Список БИК номеров")
            @RequestParam(defaultValue = "") List<@Bic String> bics,

            @Parameter(description = "Индекс страницы")
            @RequestParam(defaultValue = "0") @PageIndex int page,

            @Parameter(description = "Размер страницы")
            @RequestParam(defaultValue = "10") @PageSize int size
    ) {
        MaximumRateDepositParams params = new MaximumRateDepositParams(
                amount, term, capitalization, replenishment, partialWithdrawal, bics, page, size
        );
        CalculatedDepositList calculatedDepositList = calculatorService.getAllMaximumRateCalculatedDepositList(params);
        return calculatorMapper.toCalculatedDepositListResponseDto(calculatedDepositList);
    }

    @Operation(
            summary = "Рассчитать кредиты",
            description = "Конечная точка для расчета кредитов с наинизшей доступной ставкой"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Кредиты рассчитаны",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CalculatedCreditListResponseDto.class)
            )}
    )})
    @GetMapping("/credits")
    public CalculatedCreditListResponseDto getAllCalculatedCredits(
            @Parameter(description = "Сумма кредита в рублях")
            @RequestParam @Amount int amount,

            @Parameter(description = "Срок кредита в месяцах")
            @RequestParam @Term int term,

            @Parameter(description = "Получение без посещения банка")
            @RequestParam(required = false) Boolean creditOnline,

            @Parameter(description = "Подтверждение онлайн")
            @RequestParam(required = false) Boolean onlineApprove,

            @Parameter(description = "Наличие залога")
            @RequestParam(required = false) Boolean collateral,

            @Parameter(description = "Список БИК номеров")
            @RequestParam(defaultValue = "") List<@Bic String> bics,

            @Parameter(description = "Индекс страницы")
            @RequestParam(defaultValue = "0") @PageIndex int page,

            @Parameter(description = "Размер страницы")
            @RequestParam(defaultValue = "10") @PageSize int size
    ) {
        MinimumRateCreditParams params = new MinimumRateCreditParams(
                amount, term, creditOnline, onlineApprove, collateral, bics, page, size
        );
        CalculatedCreditList calculatedCreditList = calculatorService.getAllMinimumRateCalculatedCreditList(params);
        return calculatorMapper.toCalculatedCreditListResponseDto(calculatedCreditList);
    }

}
