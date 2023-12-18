package ru.cobp.backend.dto.deposit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankMapper;
import ru.cobp.backend.model.deposit.Deposit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DepositMapper {

    public static DepositShortResponseDto toDto(Deposit o) {
        DepositShortResponseDto dto = new DepositShortResponseDto();

        dto.setBank(BankMapper.toDto(o.getBank()));
        dto.setDepositName(o.getName());
        dto.setDepositUrl(o.getProductUrl());
        dto.setTerm(o.getTerm());
        dto.setRate(o.getRate());

        return dto;
    }

}