package ru.cobp.backend.deposit.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.deposit.dto.DepositDto;
import ru.cobp.backend.deposit.dto.NewDepositDto;
import ru.cobp.backend.deposit.service.DepositService;

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
    @GetMapping("/{id}")
    public DepositDto getDeposit(@PathVariable Long id) {
        return new DepositDto();
    }

    @Operation(
            summary = "Удалить депозит",
            description = "Конечная точка для удаления депозита"
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")

    public void deleteDeposit(@PathVariable Long id) {
    }

    @Operation(
            summary = "Добавить депозит",
            description = "Конечная точка для добавления депозита"
    )
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public DepositDto addDeposit(@PathVariable Long id,  @RequestBody NewDepositDto newDepositDto) {
        return new DepositDto();
    }

    @Operation(
            summary = "Изменить депозит",
            description = "Конечная точка для изменения депозита"
    )
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public DepositDto updateDeposit(@PathVariable Long id, @RequestBody DepositDto depositDto) {
        return new DepositDto();
    }
}
