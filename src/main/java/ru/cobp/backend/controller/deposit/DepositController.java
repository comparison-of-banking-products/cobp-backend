package ru.cobp.backend.controller.deposit;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.common.Utils;
import ru.cobp.backend.dto.calculator.DepositCalculatorMapper;
import ru.cobp.backend.dto.deposit.DepositDto;
import ru.cobp.backend.dto.deposit.DepositMapper;
import ru.cobp.backend.dto.deposit.DepositResponseDto;
import ru.cobp.backend.dto.deposit.NewDepositDto;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.service.deposit.DepositService;

import java.util.List;

@Tag(
        name = "Депозиты",
        description = "Контроллер для работы с депозитами"
)
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/deposits")
public class DepositController {
    private final DepositService depositService;

    @Operation(
            summary = "Получить список депозитов",
            description = "Конечная точка для получения депозитов"
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<DepositResponseDto> getDepositList(
            @Parameter(description = "Сумма вклада в рублях")
            @RequestParam(required = false)  @Positive Integer amount,

            @Parameter(description = "Срок вклада в месяцах")
            @RequestParam(required = false)  @Positive Integer term,

            @Parameter(description = "Вклад с капитализацией")
            @RequestParam(required = false) Boolean capitalization,

            @Parameter(description = "Вклад с пополнением")
            @RequestParam(required = false) Boolean replenishment,

            @Parameter(description = "Вклад с частичным снятием")
            @RequestParam(required = false) Boolean partialWithdrawal,

            @Parameter(description = "Индекс страницы")
            @RequestParam(defaultValue = "0") @PositiveOrZero int page,

            @Parameter(description = "Размер страницы")
            @RequestParam(defaultValue = "10") @Positive int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        List<Deposit> deposits = depositService.findAllDeposits(
                amount, term, capitalization, replenishment, partialWithdrawal, pageable
        );

        return deposits.stream()
                .map(DepositMapper::toDto)
                .toList();
    }

    @Operation(
            summary = "Найти депозит",
            description = "Конечная точка для поиска депозита"
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public DepositDto getDeposit(@PathVariable Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Operation(
            summary = "Удалить депозит",
            description = "Конечная точка для удаления депозита"
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")

    public void deleteDeposit(@PathVariable Long id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Operation(
            summary = "Добавить депозит",
            description = "Конечная точка для добавления депозита"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public DepositDto addDeposit(@RequestBody NewDepositDto newDepositDto) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Operation(
            summary = "Изменить депозит",
            description = "Конечная точка для изменения депозита"
    )
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public DepositDto updateDeposit(@PathVariable Long id, @RequestBody DepositDto depositDto) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
