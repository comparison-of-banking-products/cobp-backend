package ru.cobp.backend.controller.currency;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
import ru.cobp.backend.dto.currency.CurrencyCreateUpdateDto;
import ru.cobp.backend.dto.currency.CurrencyRateResponseDto;
import ru.cobp.backend.dto.currency.CurrencyResponseDto;
import ru.cobp.backend.mapper.CurrencyMapper;
import ru.cobp.backend.mapper.CurrencyRateMapper;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.model.currency.CurrencyRate;
import ru.cobp.backend.service.currency.CurrencyRatesService;
import ru.cobp.backend.service.currency.CurrencyService;

import java.util.List;

@Tag(
        name = "Валюты",
        description = "Контроллер для работы с валютами"
)
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    private final CurrencyRatesService currencyRateService;

    private final CurrencyMapper currencyMapper;

    private final CurrencyRateMapper currencyRateMapper;

    @Operation(
            summary = "Добавление новой валюты",
            description = "Конечная точка для добавления новой валюты"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "201",
            description = "Добавлена новая валюта",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CurrencyResponseDto.class)
            )}
    )})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CurrencyResponseDto create(@RequestBody @Valid CurrencyCreateUpdateDto newCurrencyDto) {
        Currency newCurrency = currencyMapper.fromCurrencyCreateUpdateDto(newCurrencyDto);
        Currency response = currencyService.create(newCurrency);
        return currencyMapper.toCurrencyResponseDto(response);
    }

    @Operation(
            summary = "Обновление данных по валюте",
            description = "Конечная точка для обновления данных по валюте"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Данные по валюте обновлены",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CurrencyResponseDto.class)
            )}
    )})
    @PutMapping("/{num}")
    public CurrencyResponseDto update(@PathVariable Long num,
                                      @RequestBody @Valid CurrencyCreateUpdateDto updateCurrencyDto) {
        Currency oldCurrency = currencyService.getById(num);
        Currency updateCurrency = currencyMapper.fromCurrencyCreateUpdateDto(updateCurrencyDto);
        oldCurrency = currencyMapper.updateCurrency(oldCurrency, updateCurrency);
        Currency response = currencyService.update(oldCurrency);
        return currencyMapper.toCurrencyResponseDto(response);
    }

    @Operation(
            summary = "Получить список валют",
            description = "Конечная точка для получения списка валют"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Получен список валют",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = CurrencyResponseDto.class))
            )}
    )})
    @GetMapping
    public List<CurrencyResponseDto> getAll() {
        List<Currency> response = currencyService.getAll();
        return currencyMapper.toCurrencyResponseDtos(response);
    }

    @Operation(
            summary = "Получение данных по валюте",
            description = "Конечная точка для получения данных по валюте"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Данные по валюте получены",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CurrencyResponseDto.class)
            )}
    )})
    @GetMapping("/{num}")
    public CurrencyResponseDto getById(@PathVariable Long num) {
        Currency response = currencyService.getById(num);
        return currencyMapper.toCurrencyResponseDto(response);
    }

    @Operation(
            summary = "Удалить валюту по ID",
            description = "Конечная точка для удаления валюты по ID"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "204",
            description = "Удалена валюта по ID"
    )})
    @DeleteMapping("/{num}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long num) {
        currencyService.deleteById(num);
    }

    @Operation(
            summary = "Получить актуальные валютные котировки",
            description = "Конечная точка для получения актуальных валютных котировок"
    )
    @ApiResponses(value = {@ApiResponse(
            responseCode = "200",
            description = "Получены актуальные валютные котировки",
            content = {@Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = CurrencyRateResponseDto.class))
            )}
    )})
    @GetMapping("/rates")
    public List<CurrencyRateResponseDto> getCurrencyRates() {
        List<CurrencyRate> response = currencyRateService.getCurrencyRates();
        return currencyRateMapper.toCurrencyRateResponseDtos(response);
    }

}
