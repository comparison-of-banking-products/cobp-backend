package ru.cobp.backend.service.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.cobp.backend.common.TestUtils;
import ru.cobp.backend.model.calculator.CalculatedCredit;
import ru.cobp.backend.model.calculator.CalculatedDeposit;
import ru.cobp.backend.service.credit.CreditService;
import ru.cobp.backend.service.deposit.DepositService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceImplTest {

    @Mock
    DepositService depositService;

    @Mock
    CreditService creditService;

    @InjectMocks
    CalculatorServiceImpl calculatorService;

    @Test
    void whenGetAllMaximumRateCalculatedDeposits_expectCalculatedDeposits() {
        List<CalculatedDeposit> expected = TestUtils.buildGazprombankCalculatedDeposits();

        when(depositService.findAllMaximumRateDeposits(
                anyInt(), anyInt(), anyBoolean(), anyBoolean(), anyBoolean(), anyList(), any(Pageable.class)
        )).thenReturn(TestUtils.buildDeposits());

        List<CalculatedDeposit> actual = calculatorService.getAllMaximumRateCalculatedDeposits(
                100_000,
                1,
                false,
                false,
                false,
                List.of(),
                PageRequest.ofSize(1)
        );

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0).getAnnualInterest(), actual.get(0).getAnnualInterest());
    }

    @Test
    void whenGetAllMinimumRateCalculatedCredits_expectCalculatedCredits() {
        List<CalculatedCredit> expected = TestUtils.buildGazprombankCalculatedCredits();

        when(creditService.findAllMinimumRateCredits(anyInt(), anyInt(), anyList(), any(Pageable.class)))
                .thenReturn(TestUtils.buildCredits());

        List<CalculatedCredit> actual = calculatorService.getAllMinimumRateCalculatedCredits(
                100_000, 13, List.of(), PageRequest.ofSize(1)
        );

        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0).getMonthlyPayment(), actual.get(0).getMonthlyPayment());
    }

}
