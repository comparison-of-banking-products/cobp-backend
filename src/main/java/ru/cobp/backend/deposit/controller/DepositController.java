package ru.cobp.backend.deposit.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.deposit.dto.DepositDto;
import ru.cobp.backend.deposit.dto.NewDepositDto;
import ru.cobp.backend.deposit.service.DepositService;
import ru.cobp.backend.depositrate.dto.DepositRateDto;
import ru.cobp.backend.depositrate.dto.NewDepositRateDto;

import java.util.ArrayList;
import java.util.List;

@Tag(
        name = "Депозиты",
        description = "Контроллер для работы с депозитами"
)
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/deposits")
public class DepositController {
    private DepositService depositService;

    @Operation(
            summary = "Получить список депозитов",
            description = "Конечная точка для получения депозитов"
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<DepositDto> getDepositList() {
        return new ArrayList<DepositDto>();
    }

    @Operation(
            summary = "Найти депозит",
            description = "Конечная точка для поиска депозита"
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{depositId}")
    public DepositDto getDeposit(@PathVariable Long depositId) {
        return new DepositDto();
    }

    @Operation(
            summary = "Удалить депозит",
            description = "Конечная точка для удаления депозита"
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{depositId}")

    public void deleteDeposit(@PathVariable Long depositId) {
    }

    @Operation(
            summary = "Добавить депозит",
            description = "Конечная точка для добавления депозита"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public DepositDto addDeposit(@RequestBody NewDepositDto newDepositDto) {
        return new DepositDto();
    }

    @Operation(
            summary = "Изменить депозит",
            description = "Конечная точка для изменения депозита"
    )
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{depositId}")
    public DepositDto updateDeposit(@PathVariable Long depositId, @RequestBody DepositDto depositDto) {
        return new DepositDto();
    }

    @Operation(
            summary = "Получить ставку для депозита",
            description = "Конечная точка для получения ставки депозита"
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{depositId}/rates/{rateId}")
    public DepositRateDto getDepositRate(@PathVariable Long depositId, @PathVariable Long rateId) {
        return new DepositRateDto();
    }

    @Operation(
            summary = "Получить все ставки для депозита",
            description = "Конечная точка для получения ставок депозита"
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{depositId}/rates")
    public List<DepositRateDto> getAllDepositRate(@PathVariable Long depositId) {
        return new ArrayList<DepositRateDto>();
    }

    @Operation(
            summary = "Добавить ставку для депозита",
            description = "Конечная точка для добавления ставки депозита"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("{depositId}/rates")
    public DepositRateDto addDepositRate(@PathVariable Long depositId,
                                         @RequestBody NewDepositRateDto newDepositRateDto) {
        return new DepositRateDto();
    }

    @Operation(
            summary = "Удалить ставку для депозита",
            description = "Конечная точка для удаления ставки депозита"
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{depositId}/rates/{rateId}")
    public void deleteDepositRate(@PathVariable Long depositId, @PathVariable Long rateId) {

    }

    @Operation(
            summary = "Изменить ставку для депозита",
            description = "Конечная точка для изменения ставки депозита"
    )
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{depositId}/rates/{rateId}")
    public DepositRateDto updateDepositRate(@PathVariable Long depositId, @PathVariable Long rateId,
                                            @RequestBody DepositRateDto newDepositRateDto) {
        return new DepositRateDto();
    }

}
