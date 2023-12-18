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
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.cobp.backend.common.Utils;
import ru.cobp.backend.dto.calculator.CalculatedDepositResponseDto;
import ru.cobp.backend.dto.calculator.DepositCalculatorMapper;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
import ru.cobp.backend.service.calculator.DepositCalculatorService;

import java.util.List;

@Tag(
        name = "Калькуляторы вклада и кредита",
        description = "Контроллер для работы с калькуляторами вклада и кредита"
)
@RestController
@RequestMapping(path = "/v1/calculators")
@RequiredArgsConstructor
public class DepositCalculatorController {

    private final DepositCalculatorService depositCalculatorService;

    @Operation(
            summary = "Рассчитать вклады",
            description = "Конечная точка для расчета вкладов с наивысшей доступной ставкой"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Вклады рассчитаны",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(
                            schema = @Schema(implementation = CalculatedDepositResponseDto.class)
                    )
            )}
    )})
    @GetMapping("/deposits")
    public List<CalculatedDepositResponseDto> getAllCalculatedDeposits(
            @Parameter(description = "Сумма вклада в рублях")
            @RequestParam @Positive int amount,

            @Parameter(description = "Срок вклада в месяцах")
            @RequestParam @Positive int term,

            @Parameter(description = "Индекс страницы")
            @RequestParam(defaultValue = "0") @PositiveOrZero int page,

            @Parameter(description = "Размер страницы")
            @RequestParam(defaultValue = "10") @Positive int size
    ) {
        Pageable pageable = Utils.getPageSortedByDepositRateDesc(page, size);
        List<CalculatedDeposit> deposits
                = depositCalculatorService.getAllMaximumRateCalculatedDeposits(amount, term, pageable);

        return DepositCalculatorMapper.toDtos(deposits);
    }

}
