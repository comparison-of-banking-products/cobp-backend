package ru.cobp.backend.credit.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.credit.dto.CreditDto;
import ru.cobp.backend.credit.dto.CreditParams;
import ru.cobp.backend.credit.service.CreditPublicService;

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
            @RequestParam(required = false) Boolean isActive,
            @RequestParam(required = false) Integer currenciesNum,
            @RequestParam(required = false) Integer minAmount,
            @RequestParam(required = false) Integer maxAmount,
            @RequestParam(required = false) Integer minRate,
            @RequestParam(required = false) Integer minPeriod,
            @RequestParam(required = false) Integer maxPeriod,
            @RequestParam(required = false) Integer paymentTypeId,
            @RequestParam(required = false) Boolean depositIsRequired,
            @RequestParam(required = false) Boolean onlineApprove,
            @RequestParam(required = false) Boolean onlineGetting,
            @RequestParam(required = false) Boolean insurance) {
        CreditParams params = new CreditParams(isActive, currenciesNum, minAmount, maxAmount, minRate, minPeriod,
                maxPeriod, paymentTypeId, depositIsRequired, onlineApprove, onlineGetting, insurance);
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
    CreditDto getById(@PathVariable long id) {
        return creditPublicService.getById(id);
    }

}
