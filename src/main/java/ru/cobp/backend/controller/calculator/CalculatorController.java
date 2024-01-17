package ru.cobp.backend.controller.calculator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.cobp.backend.dto.calculator.CalculatedCreditListResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedDepositListResponseDto;
import ru.cobp.backend.mapper.CalculatorMapper;
import ru.cobp.backend.model.calculator.CalculatedCreditList;
import ru.cobp.backend.model.calculator.CalculatedDepositList;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.service.calculator.CalculatorService;

import java.util.List;

@Tag(
        name = "Калькуляторы вклада и кредита",
        description = "Контроллер для работы с калькуляторами вклада и кредита"
)
@RestController
@CrossOrigin(origins = "*")
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
            @RequestParam @Positive int amount,

            @Parameter(description = "Срок вклада в месяцах")
            @RequestParam @Positive int term,

            @Parameter(description = "Вклад с капитализацией")
            @RequestParam(required = false) Boolean capitalization,

            @Parameter(description = "Вклад с пополнением")
            @RequestParam(required = false) Boolean replenishment,

            @Parameter(description = "Вклад с частичным снятием")
            @RequestParam(required = false) Boolean partialWithdrawal,

            @Parameter(description = "Список БИК номеров")
            @RequestParam(defaultValue = "") List<String> bics,

            @Parameter(description = "Индекс страницы")
            @RequestParam(defaultValue = "0") @PositiveOrZero int page,

            @Parameter(description = "Размер страницы")
            @RequestParam(defaultValue = "10") @Positive int size
    ) {
        Pageable pageable = PageRequest.of(
                page, size, Sort.sort(Deposit.class).by(Deposit::getRate).descending()
        );
        CalculatedDepositList calculatedDepositList = calculatorService.getAllMaximumRateCalculatedDepositList(
                amount, term, capitalization, replenishment, partialWithdrawal, bics, pageable
        );

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
            @RequestParam @Positive int amount,

            @Parameter(description = "Срок кредита в месяцах")
            @RequestParam @Positive int term,

            @Parameter(description = "Список БИК номеров")
            @RequestParam(defaultValue = "") List<String> bics,

            @Parameter(description = "Индекс страницы")
            @RequestParam(defaultValue = "0") @PositiveOrZero int page,

            @Parameter(description = "Размер страницы")
            @RequestParam(defaultValue = "10") @Positive int size
    ) {
        Pageable pageable = PageRequest.of(
                page, size, Sort.sort(Credit.class).by(Credit::getRate).ascending()
        );
        CalculatedCreditList calculatedCreditList = calculatorService.getAllMinimumRateCalculatedCreditList(
                amount, term, bics, pageable
        );

        return calculatorMapper.toCalculatedCreditListResponseDto(calculatedCreditList);
    }

}
