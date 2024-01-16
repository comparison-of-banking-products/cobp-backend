package ru.cobp.backend.model.calculator;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CalculatedCreditList {

    private List<CalculatedCredit> calculatedCredits;

    private Long totalElements;

}
