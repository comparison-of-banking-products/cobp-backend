package ru.cobp.backend.dto.bank;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.model.bank.Bank;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BankMapper {

    public static BankShortResponseDto toBankShortResponseDto(Bank o) {
        BankShortResponseDto dto = new BankShortResponseDto();
        dto.setName(o.getName());
        dto.setLogo(o.getLogo());
        return dto;
    }

    public static List<BankResponseDto> toBankResponseDtos(List<Bank> l) {
        return l.stream()
                .map(BankMapper::toBankResponseDto)
                .collect(Collectors.toList());
    }

    private static BankResponseDto toBankResponseDto(Bank o) {
        BankResponseDto dto = new BankResponseDto();

        dto.setBic(o.getBic());
        dto.setName(o.getName());
        dto.setLegalEntity(o.getLegalEntity());
        dto.setDescription(o.getDescription());
        dto.setLogo(o.getLogo());
        dto.setUrl(o.getUrl());

        return dto;
    }

}
