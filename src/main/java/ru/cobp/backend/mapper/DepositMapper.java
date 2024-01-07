package ru.cobp.backend.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.deposit.DepositResponseDto;
import ru.cobp.backend.dto.deposit.ScrapedDepositResponseDto;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.model.deposit.ScrapedDeposit;

import java.util.List;

@Component
@Mapper(uses = {BankMapper.class, CurrencyMapper.class})
public interface DepositMapper {

    List<DepositResponseDto> toDepositResponseDtos(List<Deposit> deposits);

    List<ScrapedDepositResponseDto> toScrapedDepositResponseDtos(List<ScrapedDeposit> scrapedDeposits);

}
