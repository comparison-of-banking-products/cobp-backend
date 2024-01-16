package ru.cobp.backend.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.cobp.backend.dto.calculator.CalculatedCreditListResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedCreditResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedDepositListResponseDto;
import ru.cobp.backend.dto.calculator.CalculatedDepositResponseDto;
import ru.cobp.backend.model.calculator.CalculatedCredit;
import ru.cobp.backend.model.calculator.CalculatedCreditList;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
import ru.cobp.backend.model.calculator.CalculatedDepositList;

import java.util.List;

@Component
@Mapper(uses = {DepositMapper.class, CreditMapper.class})
public interface CalculatorMapper {

    CalculatedDepositResponseDto toCalculatedDepositResponseDto(CalculatedDeposit calculatedDeposit);

    CalculatedCreditResponseDto toCalculatedCreditResponseDto(CalculatedCredit calculatedCredit);

    List<CalculatedDepositResponseDto> toCalculatedDepositResponseDtos(List<CalculatedDeposit> calculatedDeposits);

    List<CalculatedCreditResponseDto> toCalculatedCreditResponseDtos(List<CalculatedCredit> calculatedCredits);

    CalculatedDepositListResponseDto toCalculatedDepositListResponseDto(CalculatedDepositList calculatedDepositList);

    CalculatedCreditListResponseDto toCalculatedCreditListResponseDto(CalculatedCreditList calculatedCreditList);

}
