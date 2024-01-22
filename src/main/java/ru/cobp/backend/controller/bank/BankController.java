package ru.cobp.backend.controller.bank;

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
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.dto.bank.BankCreateUpdateDto;
import ru.cobp.backend.dto.bank.BankResponseDto;
import ru.cobp.backend.dto.bank.BankSort;
import ru.cobp.backend.mapper.BankMapper;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.service.bank.BankService;
import ru.cobp.backend.service.storage.StorageService;

import java.util.List;

@Tag(
        name = "Банки",
        description = "Контроллер для работы с банками"
)
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/banks")
public class BankController {

    private final BankService bankService;

    private final StorageService storageService;

    private final BankMapper bankMapper;

    @Operation(
            summary = "Добавление нового банка",
            description = "Конечная точка для добавления нового банка"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "201",
            description = "Добавлен новый банк",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = BankResponseDto.class)
            )}
    )})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BankResponseDto create(@RequestBody @Valid BankCreateUpdateDto newBankDto) {
        Bank newBank = bankMapper.fromBankCreateUpdateDto(newBankDto);
        Bank response = bankService.create(newBank);
        return bankMapper.toBankResponseDto(response);
    }

    @Operation(
            summary = "Обновление данных по банку",
            description = "Конечная точка для обновления данных по банку"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Данные по банку обновлены",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = BankResponseDto.class)
            )}
    )})
    @PutMapping("/{bic}")
    public BankResponseDto update(@PathVariable String bic,
                                  @RequestBody @Valid BankCreateUpdateDto updateBankDto) {
        Bank oldBank = bankService.getBankByBicOrThrowException(bic);
        Bank updateBank = bankMapper.fromBankCreateUpdateDto(updateBankDto);
        oldBank = bankMapper.updateBank(oldBank, updateBank);
        Bank response = bankService.update(oldBank);
        return bankMapper.toBankResponseDto(response);
    }

    @Operation(
            summary = "Получить банк по БИК номеру",
            description = "Конечная точка для получения банка по БИК номеру"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Получен банк по БИК номеру",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = BankResponseDto.class)
            )}
    )})
    @GetMapping("/{bic}")
    public BankResponseDto getByBic(@PathVariable String bic) {
        Bank bank = bankService.getBankByBicOrThrowException(bic);
        return bankMapper.toBankResponseDto(bank);
    }

    @Operation(
            summary = "Удалить банк по БИК номеру",
            description = "Конечная точка для удаления банка по БИК номеру"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "204",
            description = "Удален банк по БИК номеру"
    )})
    @DeleteMapping("/{bic}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String bic) {
        bankService.deleteByBic(bic);
    }

    @Operation(
            summary = "Получить список банков",
            description = "Конечная точка для получения списка банков"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Получен список банков",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = BankResponseDto.class))
            )}
    )})
    @GetMapping
    public List<BankResponseDto> getAll(
            @RequestParam(required = false) BankSort sort,

            @Parameter(description = "Список БИК-ов")
            @RequestParam(defaultValue = "") List<String> bics
    ) {
        List<Bank> banks = bankService.getAll(sort, bics);
        return bankMapper.toBankResponseDtos(banks);
    }

    @Operation(
            summary = "Получить лого банка",
            description = "Конечная точка для получения лого банка"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Получено лого банка",
            content = {@Content(mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE)}
    )})
    @GetMapping(value = "/logo/{logoName:.+}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public Resource getBankLogo(
            @PathVariable String logoName
    ) {
        return storageService.getFileAsResource(logoName);
    }

}