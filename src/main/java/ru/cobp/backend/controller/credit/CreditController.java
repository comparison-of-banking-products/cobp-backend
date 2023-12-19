package ru.cobp.backend.controller.credit;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditParams;
import ru.cobp.backend.service.credit.CreditPublicService;

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

    private final CreditPublicService creditPublicService;

    @Operation(
            summary = "Найти кредиты",
            description = "Конечная точка для поиска кредитов с различными параметрами"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Кредиты найдены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CreditDto.class)
                            )}
            )
    })
    @GetMapping
    List<CreditDto> getAll(
            @RequestParam(required = false) @Parameter(description = "Доступность предложения") Boolean isActive,
            @RequestParam(required = false) @Parameter(description = "Код валюты") Long currenciesNum,
            @RequestParam(required = false) @Parameter(description = "Минимальная сумма кредита") Integer minAmount,
            @RequestParam(required = false) @Parameter(description = "Максимальная сумма кредита") Integer maxAmount,
            @RequestParam(required = false) @Parameter(description = "Кредитная ставка") Double rate,
            @RequestParam(required = false) @Parameter(description = "Минимальный срок кредита") Integer minPeriod,
            @RequestParam(required = false) @Parameter(description = "Максимальный срок кредита") Integer maxPeriod) {
        CreditParams params = new CreditParams(isActive, currenciesNum, minAmount, maxAmount, rate, minPeriod,
                maxPeriod);
        return creditPublicService.getAll(params);
    }

    @Operation(
            summary = "Найти кредит по id",
            description = "Конечная точка для поиска кредита по id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Кредит по id найден",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CreditDto.class)
                            )}
            )
    })
    @GetMapping("/{id}")
    CreditDto getById(@PathVariable @Parameter(description = "Идентификатор кредита") long id) {
        return creditPublicService.getById(id);
    }

}
