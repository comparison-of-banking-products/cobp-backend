package ru.cobp.backend.deposit.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cobp.backend.deposit.dto.DepositDto;

@Tag(
        name = "Депозиты",
        description = "Контроллер для работы с депозитами"
)
@RestController
@RequestMapping(path = "/v1/deposits")
public class DepositController {

    @Operation(
            summary = "Найти депозит",
            description = "Конечная точка для поиска депозита"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Депозит найден",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DepositDto.class)
                            )}
            )
    })
    @GetMapping
    public DepositDto getDeposit() {
        DepositDto deposit = new DepositDto();
        deposit.setName("deposit");
        return deposit;
    }

}
