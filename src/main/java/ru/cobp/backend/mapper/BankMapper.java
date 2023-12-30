package ru.cobp.backend.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.bank.BankResponseDto;
import ru.cobp.backend.dto.bank.BankShortResponseDto;
import ru.cobp.backend.model.bank.Bank;

import java.util.List;

@Component
@Mapper
public interface BankMapper {

    List<BankResponseDto> toBankResponseDtos(List<Bank> banks);

    BankResponseDto toBankResponseDto(Bank bank);

    BankShortResponseDto toBankShortResponseDto(Bank bank);

}
