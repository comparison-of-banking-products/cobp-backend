package ru.cobp.backend.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.CreditResponseDto;
import ru.cobp.backend.dto.credit.CreditShortResponseDto;
import ru.cobp.backend.model.credit.Credit;

import java.util.List;

@Component
@Mapper
public interface CreditMapper {

    CreditResponseDto toCreditResponseDto(Credit credit);

    CreditShortResponseDto toCreditShortResponseDto(Credit credit);

    List<CreditResponseDto> toCreditResponseDtos(List<Credit> credits);

}
