package ru.cobp.backend.dto.credit;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.bank.BankMapper;
import ru.cobp.backend.model.credit.Credit;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditMapper {

    public static CreditShortResponseDto toDto(Credit o) {
        CreditShortResponseDto dto = new CreditShortResponseDto();

        dto.setBank(BankMapper.toShortDto(o.getBank()));
        dto.setCreditName(o.getName());
        dto.setCreditUrl(o.getProductUrl());
        dto.setTerm(o.getTerm());
        dto.setRate(o.getRate());

        return dto;
    }

}
