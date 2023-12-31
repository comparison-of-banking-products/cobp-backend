package ru.cobp.backend.controller.currency;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cobp.backend.dto.currency.CurrencyDto;
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
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    private final CurrencyRatesService currencyRateService;

    private final CurrencyMapper currencyMapper;

    private final CurrencyRateMapper currencyRateMapper;

    @PostMapping
    public ResponseEntity<CurrencyDto> create(@RequestBody CurrencyDto currencyDto) {
        log.info("Получен POST запрос по эндпоинту /currencies на добавление Currency {}.", currencyDto);
        return new ResponseEntity<>(currencyService.create(currencyDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CurrencyDto> update(@PathVariable Long id, @RequestBody CurrencyDto currencyDto) {
        log.info("Получен POST запрос по эндпоинту /currencies/{} на обновление Currency {}.", id, currencyDto);
        return new ResponseEntity<>(currencyService.update(id, currencyDto), HttpStatus.OK);
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
        List<Currency> currencies = currencyService.getAll();
        return currencyMapper.toCurrencyResponseDtos(currencies);
    }

    @GetMapping("/{id}")
    public CurrencyResponseDto getById(@PathVariable Long id) {
        log.info("Получен GET запрос по эндпоинту /currencies/{} на обновление Currency с ID {}.", id, id);
        Currency currency = currencyService.getById(id);
        return currencyMapper.toCurrencyResponseDto(currency);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CurrencyDto> delete(@PathVariable Long id) {
        log.info("Получен DELETE запрос по эндпоинту /currencies/{} на удаление Currency {}.", id, id);
        currencyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
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
        List<CurrencyRate> rates = currencyRateService.getCurrencyRates();
        return currencyRateMapper.toCurrencyRateResponseDtos(rates);
    }

}
