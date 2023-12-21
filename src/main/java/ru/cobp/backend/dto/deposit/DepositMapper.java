package ru.cobp.backend.dto.deposit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankMapper;
import ru.cobp.backend.model.deposit.Deposit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DepositMapper {

    public static DepositResponseDto toDto(Deposit o) {
        DepositResponseDto dto = new DepositResponseDto();

        dto.setBank(BankMapper.toShortDto(o.getBank()));
        dto.setDepositName(o.getName());
        dto.setDepositUrl(o.getProductUrl());
        dto.setTerm(o.getTerm());
        dto.setRate(o.getRate());
        dto.setCapitalization(o.getCapitalization());
        dto.setReplenishment(o.getReplenishment());
        dto.setPartialWithdrawal(o.getPartialWithdrawal());

        return dto;
    }

}
