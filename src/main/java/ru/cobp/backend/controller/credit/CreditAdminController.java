package ru.cobp.backend.controller.credit;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.service.credit.CreditAdminService;

@Tag(
        name = "Кредиты для администратора",
        description = "Приватный контроллер для работы с кредитами"
)
@RestController
@RequestMapping(path = "/v1/admin/credits")
@Slf4j
@RequiredArgsConstructor
@Validated
public class CreditAdminController {

    private final CreditAdminService creditAdminService;


    @Operation(
            summary = "Создать предложение по кредиту",
            description = "Конечная точка для создания кредитов"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Кредит создан",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CreditDto.class)
                            )}
            )
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreditDto create(@Valid @RequestBody @Parameter(description = "Новый кредит", required = true) NewCreditDto newCreditDto) {
        return creditAdminService.create(newCreditDto);
    }

    @Operation(
            summary = "Обновить предложение по кредиту",
            description = "Конечная точка для обновления кредитов"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Кредит обновлен",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CreditDto.class)
                            )}
            )
    })
    @PutMapping("/{id}")
    public CreditDto update(@PathVariable @Parameter(description = "Идентификатор кредита", required = true) Long id,
                            @RequestBody @Parameter(description = "Обновленный кредит", required = true) CreditDto creditDto) {
        return creditAdminService.update(id, creditDto);
    }

    @Operation(
            summary = "Удалить предложение по кредиту",
            description = "Конечная точка для удаления кредитов"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Кредит удален",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CreditDto.class)
                            )}
            )
    })
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Parameter(description = "Идентификатор кредита", required = true) Long id) {
        creditAdminService.delete(id);
    }

}
