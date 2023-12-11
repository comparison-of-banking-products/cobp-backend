package ru.cobp.backend.depositrate.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.depositrate.dto.DepositRateDto;
import ru.cobp.backend.depositrate.dto.NewDepositRateDto;
import ru.cobp.backend.depositrate.service.DepositRateService;

@Tag(
        name = "Ставки депозитов",
        description = "Контроллер для со ставками депозита"
)
@RequestMapping(path = "/v1/deposits/{depositId}/rates")
@RestController
@RequiredArgsConstructor
public class DepositRateController {
    private final DepositRateService depositRateService;

    @Operation(
            summary = "Добавить ставку для депозита",
            description = "Конечная точка для добавления ставки депозита"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public DepositRateDto addDepositRate(@PathVariable Long depositId, @RequestBody NewDepositRateDto newDepositRateDto) {
        return new DepositRateDto();
    }
}
