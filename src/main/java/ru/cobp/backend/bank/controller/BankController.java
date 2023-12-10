package ru.cobp.backend.bank.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cobp.backend.bank.dto.BankDto;
import ru.cobp.backend.bank.service.BankService;

import java.util.List;

@Tag(
        name = "Банки",
        description = "Контроллер для работы с банками"
)
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/banks")
public class BankController {

    private final BankService bankService;

    @PostMapping
    public ResponseEntity<BankDto> create(@RequestBody BankDto bankDto) {
        return new ResponseEntity<>(bankService.create(bankDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankDto> update(@PathVariable Long id, @RequestBody BankDto bankDto) {
        return new ResponseEntity<>(bankService.update(id, bankDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(bankService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BankDto> delete(@PathVariable Long id) {
        bankService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BankDto>> getAll(@RequestBody BankDto bankDto) {
        return new ResponseEntity<>(bankService.getAll(), HttpStatus.OK);
    }

}
