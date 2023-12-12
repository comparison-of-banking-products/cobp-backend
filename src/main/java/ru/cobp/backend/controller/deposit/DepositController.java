package ru.cobp.backend.controller.deposit;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.dto.deposit.DepositDto;
import ru.cobp.backend.dto.deposit.NewDepositDto;
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

    @Operation(
            summary = "Получить список депозитов",
            description = "Конечная точка для получения депозитов"
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<DepositDto> getDepositList() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Operation(
            summary = "Найти депозит",
            description = "Конечная точка для поиска депозита"
    )
    @ResponseStatus(HttpStatus.OK)
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

}
