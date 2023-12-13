package ru.cobp.backend.dto.calculator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.service.calculator.impl.DepositCalculator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DepositCalculatorMapper {

    public static DepositCalculatorResponse toResponse(DepositCalculator dc) {
        DepositCalculatorResponse resp = new DepositCalculatorResponse();

        resp.setDepositId(dc.getDepositId());
        resp.setRate(dc.getRate());
        resp.setAnnualProfit(dc.getAnnualProfit());
        resp.setMaturityProfit(dc.getMaturityProfit());

        return resp;
    }

}
