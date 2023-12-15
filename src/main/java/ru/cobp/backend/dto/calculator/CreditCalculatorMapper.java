package ru.cobp.backend.dto.calculator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import ru.cobp.backend.model.calculator.CreditCalculator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditCalculatorMapper {

    public static CreditCalculatorResponse toResponse(CreditCalculator cc) {
        CreditCalculatorResponse resp = new CreditCalculatorResponse();

        resp.setCreditId(cc.getCreditId());
        resp.setRate(cc.getRate());
        resp.setMonthlyPayment(cc.getMonthlyPayment());
        resp.setTotalInterest(cc.getTotalInterest());
        resp.setTotalPayments(cc.getTotalPayments());

        return resp;
    }

}
