package ru.cobp.backend.controller.bank;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.cobp.backend.dto.bank.BankMapper;
import ru.cobp.backend.dto.bank.BankResponseDto;
import ru.cobp.backend.dto.bank.NewBankDto;
import ru.cobp.backend.dto.bank.ResponseBankDto;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.service.bank.BankService;
import ru.cobp.backend.service.storage.StorageService;

import java.util.List;

@Tag(
        name = "Банки",
        description = "Контроллер для работы с банками"
)
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/banks")
public class BankController {

    private final BankService bankService;

    private final StorageService storageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewBankDto create(@RequestBody NewBankDto newBankDto) {
        return bankService.create(newBankDto);
    }

    @PutMapping("/{bic}")
    public NewBankDto update(@PathVariable Long bic, @RequestBody NewBankDto newBankDto) {
        return bankService.update(bic, newBankDto);
    }

    @GetMapping("/{bic}")
    public ResponseBankDto getByBic(@PathVariable Long bic) {
        return bankService.getByBic(bic);
    }

    @DeleteMapping("/{bic}")
    public void delete(@PathVariable Long bic) {
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
    public List<BankResponseDto> getAll() {
        List<Bank> banks = bankService.getAll();
        return BankMapper.toDtos(banks);
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
