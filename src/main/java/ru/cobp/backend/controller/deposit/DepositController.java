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
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.dto.deposit.DepositListResponseDto;
import ru.cobp.backend.dto.deposit.DepositParams;
import ru.cobp.backend.dto.deposit.DepositPatchRequestDto;
import ru.cobp.backend.dto.deposit.DepositPostRequestDto;
import ru.cobp.backend.dto.deposit.DepositResponseDto;
import ru.cobp.backend.dto.deposit.ScrapedDepositResponseDto;
import ru.cobp.backend.mapper.DepositMapper;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.model.deposit.DepositPatch;
import ru.cobp.backend.model.deposit.ScrapedDeposit;
import ru.cobp.backend.service.deposit.DepositService;

import java.util.List;

@Tag(
        name = "Вклады",
        description = "Контроллер для работы с вкладами"
)
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/deposits")
public class DepositController {

    private final DepositService depositService;

    private final DepositMapper depositMapper;

    @Operation(
            summary = "Добавить вклад",
            description = "Конечная точка для добавления вклада"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "201",
            description = "Вклад добавлен",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = DepositResponseDto.class)
            )}
    )})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepositResponseDto postDeposit(
            @RequestBody DepositPostRequestDto depositDto
    ) {
        Deposit deposit = depositMapper.toDeposit(depositDto);
        Deposit saved = depositService.save(deposit);
        return depositMapper.toDepositResponseDto(saved);
    }

    @Operation(
            summary = "Изменить вклад",
            description = "Конечная точка для изменения вклада"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Вклад изменен",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = DepositResponseDto.class)
            )}
    )})
    @PatchMapping("/{id}")
    public DepositResponseDto patchDeposit(
            @Parameter(description = "Идентификатор вклада")
            @PathVariable long id,

            @RequestBody DepositPatchRequestDto depositDto
    ) {
        DepositPatch patch = depositMapper.toDepositPatch(depositDto);
        Deposit updated = depositService.update(id, patch);
        return depositMapper.toDepositResponseDto(updated);
    }

    @Operation(
            summary = "Найти вклад",
            description = "Конечная точка для поиска вклада"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Вклад найден",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = DepositResponseDto.class)
            )}
    )})
    @GetMapping("/{id}")
    public DepositResponseDto getDepositById(
            @Parameter(description = "Идентификатор вклада")
            @PathVariable long id
    ) {
        Deposit deposit = depositService.findById(id);
        return depositMapper.toDepositResponseDto(deposit);
    }

    @Operation(
            summary = "Найти вклады",
            description = "Конечная точка для поиска вкладов по параметрам"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Вклады найдены",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = DepositListResponseDto.class)
            )}
    )})
    @GetMapping
    public DepositListResponseDto getAllDepositList(
            @Parameter(description = "Список БИК номеров")
            @RequestParam(defaultValue = "") List<String> bics,

            @Parameter(description = "Активный")
            @RequestParam(required = false) Boolean isActive,

            @Parameter(description = "Минимальная сумма вклада")
            @RequestParam(required = false) Integer amountMin,

            @Parameter(description = "Максимальная сумма вклада")
            @RequestParam(required = false) Integer amountMax,

            @Parameter(description = "Минимальный срок вклада")
            @RequestParam(required = false) Integer termMin,

            @Parameter(description = "Максимальный срок вклада")
            @RequestParam(required = false) Integer termMax,

            @Parameter(description = "Минимальная процентная ставка")
            @RequestParam(required = false) Double rateMin,

            @Parameter(description = "Максимальная процентная ставка")
            @RequestParam(required = false) Double rateMax,

            @Parameter(description = "С капитализацией")
            @RequestParam(required = false) Boolean capitalization,

            @Parameter(description = "С пополнением")
            @RequestParam(required = false) Boolean replenishment,

            @Parameter(description = "С частичным снятием")
            @RequestParam(required = false) Boolean partialWithdrawal,

            @Parameter(description = "Индекс страницы")
            @RequestParam(defaultValue = "0") @PositiveOrZero int page,

            @Parameter(description = "Размер страницы")
            @RequestParam(defaultValue = "10") @Positive int size
    ) {
        DepositParams params = new DepositParams(
                bics,
                isActive,
                amountMin,
                amountMax,
                termMin,
                termMax,
                rateMin,
                rateMax,
                capitalization,
                replenishment,
                partialWithdrawal,
                page,
                size
        );
        Page<Deposit> depositPage = depositService.findAllDepositPage(params);
        List<DepositResponseDto> depositResponseDtos = depositMapper.toDepositResponseDtos(depositPage.getContent());
        return new DepositListResponseDto(depositResponseDtos, depositPage.getTotalElements());
    }

    @Operation(
            summary = "Удалить вклад",
            description = "Конечная точка для удаления вклада"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "204",
            description = "Вклад удален"
    )})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDeposit(
            @Parameter(description = "Идентификатор вклада")
            @PathVariable long id
    ) {
        depositService.deleteById(id);
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
        List<ScrapedDeposit> deposits = depositService.findAllScrapedDeposits();
        return depositMapper.toScrapedDepositResponseDtos(deposits);
    }

}
