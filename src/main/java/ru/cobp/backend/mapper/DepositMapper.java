package ru.cobp.backend.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.deposit.DepositPatchRequestDto;
import ru.cobp.backend.dto.deposit.DepositPostRequestDto;
import ru.cobp.backend.dto.deposit.DepositResponseDto;
import ru.cobp.backend.dto.deposit.DepositShortResponseDto;
import ru.cobp.backend.dto.deposit.ScrapedDepositResponseDto;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.model.deposit.DepositPatch;
import ru.cobp.backend.model.deposit.ScrapedDeposit;

import java.util.List;

@Component
@Mapper(uses = {BankMapper.class, CurrencyMapper.class})
public interface DepositMapper {

    DepositResponseDto toDepositResponseDto(Deposit deposit);

    DepositShortResponseDto toDepositShortResponseDto(Deposit deposit);

    List<DepositResponseDto> toDepositResponseDtos(List<Deposit> deposits);

    List<ScrapedDepositResponseDto> toScrapedDepositResponseDtos(List<ScrapedDeposit> scrapedDeposits);

    @Mapping(target = "bank.bic", source = "bic")
    @Mapping(target = "currency.num", source = "currencyNum")
    Deposit toDepositPatch(DepositPostRequestDto dto);

    DepositPatch toDepositPatch(DepositPatchRequestDto dto);

    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
    )
    void patchDeposit(@MappingTarget Deposit deposit, DepositPatch patch);

}
