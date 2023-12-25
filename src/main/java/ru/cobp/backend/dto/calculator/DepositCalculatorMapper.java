package ru.cobp.backend.dto.calculator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.deposit.DepositMapper;
import ru.cobp.backend.model.calculator.CalculatedDeposit;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DepositCalculatorMapper {

    public static CalculatedDepositResponseDto toDto(CalculatedDeposit o) {
        CalculatedDepositResponseDto dto = new CalculatedDepositResponseDto();

        dto.setDeposit(DepositMapper.toDto(o.getDeposit()));
        dto.setAnnualInterest(o.getAnnualInterest());
        dto.setMaturityInterest(o.getMaturityInterest());
        dto.setTotalAmount(o.getTotalAmount());

        return dto;
    }

    public static List<CalculatedDepositResponseDto> toDtos(List<CalculatedDeposit> l) {
        return l.stream()
                .map(DepositCalculatorMapper::toDto)
                .collect(Collectors.toList());
    }

}
