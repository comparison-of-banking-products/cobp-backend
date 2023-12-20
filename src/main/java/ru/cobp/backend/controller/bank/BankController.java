package ru.cobp.backend.controller.bank;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.dto.bank.BankMapper;
import ru.cobp.backend.dto.bank.NewBankDto;
import ru.cobp.backend.dto.bank.ResponseBankDto;
import ru.cobp.backend.service.bank.BankService;

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
        return BankMapper.toResponseBankDto(bankService.getByBic(bic));
    }

    @DeleteMapping("/{bic}")
    public void delete(@PathVariable Long bic) {
        bankService.deleteByBic(bic);
    }

    @GetMapping
    public List<ResponseBankDto> getAll() {
        return bankService.getAll();
    }

}
