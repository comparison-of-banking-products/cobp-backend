package ru.cobp.backend.controller.credit;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.dto.CreditResponseDto;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditParams;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.mapper.CreditMapper;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.service.credit.CreditService;

import java.util.List;

@Tag(
        name = "Кредиты",
        description = "Контроллер для работы с кредитами"
)
@RestController
@RequestMapping(path = "/v1/credits")
@Slf4j
@RequiredArgsConstructor
@Validated
public class CreditController {

    private final CreditService creditService;

    private final CreditMapper creditMapper;

    @Operation(
            summary = "Найти кредиты",
            description = "Конечная точка для поиска кредитов с различными параметрами"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Кредиты найдены",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = CreditResponseDto.class))
            )}
    )})
    @GetMapping
    public List<CreditResponseDto> getAll(
            @RequestParam(required = false) @Parameter(description = "Доступность предложения") Boolean isActive,
            @RequestParam(required = false) @Parameter(description = "Код валюты") Long currencyNum,
            @RequestParam(required = false) @Parameter(description = "Минимальная сумма кредита") Integer minAmount,
            @RequestParam(required = false) @Parameter(description = "Максимальная сумма кредита") Integer maxAmount,
            @RequestParam(required = false) @Parameter(description = "Кредитная ставка") Double rate,
            @RequestParam(required = false) @Parameter(description = "Минимальный срок кредита") Integer minPeriod,
            @RequestParam(required = false) @Parameter(description = "Максимальный срок кредита") Integer maxPeriod,
            @RequestParam(required = false) @Parameter(description = "Тип платежа") String paymentType
    ) {
        CreditParams params = new CreditParams(isActive, currencyNum, minAmount, maxAmount, rate, minPeriod,
                maxPeriod, paymentType);
        List<Credit> credits = creditService.getAll(params);
        return creditMapper.toCreditResponseDtos(credits);
    }

    @Operation(
            summary = "Найти кредит по id",
            description = "Конечная точка для поиска кредита по id"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Кредит по id найден",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CreditResponseDto.class)
            )}
    )})
    @GetMapping("/{id}")
    public CreditResponseDto getById(@PathVariable @Parameter(description = "Идентификатор кредита") long id) {
        Credit credit = creditService.getById(id);
        return creditMapper.toCreditResponseDto(credit);
    }

    @Operation(
            summary = "Создать предложение по кредиту",
            description = "Конечная точка для создания кредитов"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "201",
            description = "Кредит создан",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CreditResponseDto.class)
            )}
    )})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreditResponseDto create(@Valid @RequestBody @Parameter(description = "Новый кредит", required = true) NewCreditDto newCreditDto) {
        Credit credit = creditService.create(newCreditDto);
        return creditMapper.toCreditResponseDto(credit);
    }

    @Operation(
            summary = "Обновить предложение по кредиту",
            description = "Конечная точка для обновления кредитов"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Кредит обновлен",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CreditResponseDto.class)
            )}
    )})
    @PutMapping("/{id}")
    public CreditResponseDto update(
            @PathVariable @Parameter(description = "Идентификатор кредита", required = true) Long id,
            @RequestBody @Parameter(description = "Обновленный кредит", required = true) CreditDto creditDto
    ) {
        Credit credit = creditService.update(id, creditDto);
        return creditMapper.toCreditResponseDto(credit);
    }

    @Operation(
            summary = "Удалить предложение по кредиту",
            description = "Конечная точка для удаления кредитов"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "204",
            description = "Кредит удален",
            content = {@Content(schema = @Schema(hidden = true))}
    )})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Parameter(description = "Идентификатор кредита", required = true) Long id) {
        creditService.delete(id);
    }

}
