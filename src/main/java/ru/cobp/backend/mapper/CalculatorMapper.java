package ru.cobp.backend.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.calculator.CalculatedCreditResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedDepositResponseDto;
import ru.cobp.backend.model.calculator.CalculatedCredit;
import ru.cobp.backend.model.calculator.CalculatedDeposit;

import java.util.List;

@Component
@Mapper
public interface CalculatorMapper {

    CalculatedDepositResponseDto toCalculatedDepositResponseDto(CalculatedDeposit calculatedDeposit);

    CalculatedCreditResponseDto toCalculatedCreditResponseDto(CalculatedCredit calculatedCredit);

    List<CalculatedDepositResponseDto> toCalculatedDepositResponseDtos(List<CalculatedDeposit> calculatedDeposits);

    List<CalculatedCreditResponseDto> toCalculatedCreditResponseDtos(List<CalculatedCredit> calculatedCredits);

}
