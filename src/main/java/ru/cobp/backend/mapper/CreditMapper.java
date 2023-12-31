package ru.cobp.backend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.credit.CreditResponseDto;
import ru.cobp.backend.dto.credit.CreditShortResponseDto;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.credit.PaymentType;

import java.util.List;

@Component
@Mapper(uses = BankMapper.class)
public interface CreditMapper {

    @Mapping(source = "paymentType", target = "paymentType", qualifiedByName = "paymentTypeToString")
    CreditResponseDto toCreditResponseDto(Credit credit);

    @Named("paymentTypeToString")
    public static String paymentTypeToString(PaymentType paymentType) {
        return paymentType.getTitle();
    }

    CreditShortResponseDto toCreditShortResponseDto(Credit credit);

    List<CreditResponseDto> toCreditResponseDtos(List<Credit> credits);

}
