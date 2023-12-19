package ru.cobp.backend.service.deposit;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.common.Utils;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.model.deposit.QDeposit;
import ru.cobp.backend.repository.deposit.DepositRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService {

    private static final QDeposit Q_DEPOSIT = QDeposit.deposit;

    private final DepositRepository depositRepository;

    @Override
    public List<Deposit> findAllMaximumRateDeposits(int amount, int term, Pageable pageable) {
        Predicate p = buildQDepositMaximumRatePredicateBy(amount, term);
        Iterable<Deposit> deposits = depositRepository.findAll(p, pageable);
        return Utils.toList(deposits);
    }

    private Predicate buildQDepositMaximumRatePredicateBy(int amount, int term) {
        return new BooleanBuilder()
                .and(Q_DEPOSIT.rate.loe(JPAExpressions
                        .select(Q_DEPOSIT.rate.max())
                        .from(Q_DEPOSIT)
                ))
                .and(Q_DEPOSIT.amountMin.loe(amount))
                .and(Q_DEPOSIT.amountMax.goe(amount))
                .and(Q_DEPOSIT.term.eq(term));
    }

}
