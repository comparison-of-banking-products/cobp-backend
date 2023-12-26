package ru.cobp.backend.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.deposit.DepositResponseDto;
import ru.cobp.backend.model.deposit.Deposit;

import java.util.List;

@Component
@Mapper
public interface DepositMapper {

    List<DepositResponseDto> toDepositResponseDtos(List<Deposit> deposits);

}
