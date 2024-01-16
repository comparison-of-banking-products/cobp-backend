package ru.cobp.backend.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.bank.BankResponseDto;
import ru.cobp.backend.dto.bank.BankShortResponseDto;
import ru.cobp.backend.dto.bank.BankCreateUpdateDto;
import ru.cobp.backend.model.bank.Bank;

import java.util.List;

@Component
@Mapper
public interface BankMapper {

    List<BankResponseDto> toBankResponseDtos(List<Bank> banks);

    BankResponseDto toBankResponseDto(Bank bank);

    BankShortResponseDto toBankShortResponseDto(Bank bank);

    Bank fromBankCreateUpdateDto(BankCreateUpdateDto createUpdateDto);

    default Bank updateBank(Bank oldBank, Bank updateBank) {
        if (updateBank.getName() != null) {
            oldBank.setName(updateBank.getName());
        }
        if (updateBank.getLegalEntity() != null) {
            oldBank.setLegalEntity(updateBank.getLegalEntity());
        }
        if (updateBank.getDescription() != null) {
            oldBank.setDescription(updateBank.getDescription());
        }
        if (updateBank.getLogo() != null) {
            oldBank.setLogo(updateBank.getLogo());
        }
        if (updateBank.getUrl() != null) {
            oldBank.setUrl(updateBank.getUrl());
        }
        return oldBank;
    }

}
