package ru.cobp.backend.dto.calculator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.dto.credit.CreditMapper;
import ru.cobp.backend.model.calculator.CalculatedCredit;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditCalculatorMapper {

    public static CalculatedCreditResponseDto toDto(CalculatedCredit o) {
        CalculatedCreditResponseDto dto = new CalculatedCreditResponseDto();

        dto.setCredit(CreditMapper.toDto(o.getCredit()));
        dto.setMonthlyPayment(o.getMonthlyPayment());
        dto.setTotalPayments(o.getTotalPayments());
        dto.setMaturityInterest(o.getMaturityInterest());

        return dto;
    }

    public static List<CalculatedCreditResponseDto> toDtos(List<CalculatedCredit> o) {
        return o.stream()
                .map(CreditCalculatorMapper::toDto)
                .collect(Collectors.toList());
    }

}
