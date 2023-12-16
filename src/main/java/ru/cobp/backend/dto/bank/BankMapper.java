package ru.cobp.backend.dto.bank;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.model.bank.Bank;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BankMapper {

    public static BankShortResponseDto toDto(Bank o) {
        BankShortResponseDto dto = new BankShortResponseDto();

        dto.setName(o.getName());
        dto.setLogo(o.getLogo());

        return dto;
    }

}
