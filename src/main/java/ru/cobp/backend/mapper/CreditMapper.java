package ru.cobp.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.credit.CreditResponseDto;
import ru.cobp.backend.dto.credit.CreditShortResponseDto;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.model.credit.Credit;

import java.util.List;

@Component
@Mapper(uses = {BankMapper.class, CurrencyMapper.class})
public interface CreditMapper {

    CreditResponseDto toCreditResponseDto(Credit credit);

    CreditShortResponseDto toCreditShortResponseDto(Credit credit);

    List<CreditResponseDto> toCreditResponseDtos(List<Credit> credits);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "bank", ignore = true)
    @Mapping(target = "currency", ignore = true)
    Credit toCredit(NewCreditDto newCreditDto);

}
