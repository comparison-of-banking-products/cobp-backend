package ru.cobp.backend.controller.deposit;

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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.dto.deposit.DepositDto;
import ru.cobp.backend.dto.deposit.DepositResponseDto;
import ru.cobp.backend.dto.deposit.NewDepositDto;
import ru.cobp.backend.dto.deposit.ScrapedDepositResponseDto;
import ru.cobp.backend.mapper.DepositMapper;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.model.deposit.ScrapedDeposit;
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

    private final DepositMapper depositMapper;

    @Operation(
            summary = "Найти вклады",
            description = "Конечная точка для поиска вкладов по параметрам"
    )
    @GetMapping
    public List<DepositResponseDto> getDepositList(
            @Parameter(description = "Минимальная сумма вклада в рублях")
            @RequestParam(required = false) @Positive Integer minAmount,

            @Parameter(description = "Максимальная сумма вклада в рублях")
            @RequestParam(required = false) @Positive Integer maxAmount,

            @Parameter(description = "Минимальный срок вклада в месяцах")
            @RequestParam(required = false) @Positive Integer minTerm,

            @Parameter(description = "Максимальный срок вклада в месяцах")
            @RequestParam(required = false) @Positive Integer maxTerm,

            @Parameter(description = "Минимальная доходность вклада")
            @RequestParam(required = false) @Positive Double minRate,

            @Parameter(description = "Максимальная доходность вклада")
            @RequestParam(required = false) @Positive Double maxRate,

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
                minAmount, maxAmount, minTerm, maxTerm, minRate, maxRate, capitalization, replenishment,
                partialWithdrawal, pageable
        );

        return depositMapper.toDepositResponseDtos(deposits);
    }

    @Operation(
            summary = "Найти депозит",
            description = "Конечная точка для поиска депозита"
    )
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

    @Operation(
            summary = "Найти скрапленные вклады",
            description = "Конечная точка для поиска вкладов собранных технологией веб-скрапинга"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Найдены скрапленные вклады",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = ScrapedDepositResponseDto.class))
            )}
    )})
    @GetMapping("/scraped")
    public List<ScrapedDepositResponseDto> getAllScrapedDeposits() {
        List<ScrapedDeposit> deposits = depositService.getAllScrapedDeposits();
        return depositMapper.toScrapedDepositResponseDtos(deposits);
    }

}
