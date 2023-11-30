package ru.cobp.backend.deposit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cobp.backend.deposit.dto.DepositDto;

@RestController
@RequestMapping(path = "/deposit")
public class DepositController {

    @GetMapping
    public DepositDto getDeposit() {
        DepositDto deposit = new DepositDto();
        deposit.setName("deposit");
        return deposit;
    }

}
