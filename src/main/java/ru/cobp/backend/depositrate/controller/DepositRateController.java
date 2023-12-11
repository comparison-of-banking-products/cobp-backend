package ru.cobp.backend.depositrate.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.depositrate.dto.DepositRateDto;
import ru.cobp.backend.depositrate.dto.NewDepositRateDto;
import ru.cobp.backend.depositrate.service.DepositRateService;

import java.util.ArrayList;
import java.util.List;

@Tag(
        name = "Ставки депозитов",
        description = "Контроллер для ставок по депозитам"
)
@RequestMapping(path = "/v1/deposits/{depositId}/rates")
@RestController
@RequiredArgsConstructor
public class DepositRateController {
    private final DepositRateService depositRateService;

    @Operation(
            summary = "Получить ставку для депозита",
            description = "Конечная точка для получения ставки депозита"
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public DepositRateDto getDepositRate(@PathVariable Long depositId, @PathVariable Long id) {
        return new DepositRateDto();
    }

    @Operation(
            summary = "Получить все ставки для депозита",
            description = "Конечная точка для получения ставок депозита"
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<DepositRateDto> getAllDepositRate(@PathVariable Long depositId) {
        return new ArrayList<DepositRateDto>();
    }

    @Operation(
            summary = "Добавить ставку для депозита",
            description = "Конечная точка для добавления ставки депозита"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public DepositRateDto addDepositRate(@PathVariable Long depositId,
                                         @RequestBody NewDepositRateDto newDepositRateDto) {
        return new DepositRateDto();
    }

    @Operation(
            summary = "Удалить ставку для депозита",
            description = "Конечная точка для удаления ставки депозита"
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteDepositRate(@PathVariable Long depositId, @PathVariable Long id) {

    }

    @Operation(
            summary = "Изменить ставку для депозита",
            description = "Конечная точка для изменения ставки депозита"
    )
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public DepositRateDto updateDepositRate(@PathVariable Long depositId, @PathVariable Long id,
                                         @RequestBody DepositRateDto newDepositRateDto) {
        return new DepositRateDto();
    }

}
