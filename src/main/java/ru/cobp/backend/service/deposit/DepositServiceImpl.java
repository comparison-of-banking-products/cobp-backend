package ru.cobp.backend.service.deposit;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.common.Constant;
import ru.cobp.backend.exception.ExceptionUtil;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.model.deposit.QDeposit;
import ru.cobp.backend.repository.deposit.DepositRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService {

    private static final QDeposit Q_DEPOSIT = QDeposit.deposit;

    private final DepositRepository depositRepository;

    @Override
    public Deposit findDeposit(Integer amount, Integer term, Double rate) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Deposit findMaximumRateDeposit(Integer amount, Integer term) {
        List<Deposit> deposits = findMaximumRateDeposits(amount, term);
        if (deposits.isEmpty()) {
            throw ExceptionUtil.getDepositNotFoundException();
        }
        return deposits.get(0);
    }

    @Override
    public List<Deposit> findDeposits(Integer amount, Integer term, Double rate) {
        Predicate p = buildQDepositRateLessOrEqualPredicateBy(amount, term, rate);
        Sort s = Sort.by(Constant.DEPOSIT_RATE).descending();
        Iterable<Deposit> deposits = depositRepository.findAll(p, s);
        return toList(deposits);
    }

    @Override
    public List<Deposit> findMaximumRateDeposits(Integer amount, Integer term) {
        Predicate p = buildQDepositMaximumRatePredicateBy(amount, term);
        Sort s = Sort.by(Constant.DEPOSIT_RATE).descending();
        Iterable<Deposit> deposits = depositRepository.findAll(p, s);
        return toList(deposits);
    }

    private List<Deposit> toList(Iterable<Deposit> iterable) {
        return StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    private Predicate buildQDepositRateLessOrEqualPredicateBy(Integer amount, Integer term, Double rate) {
        BooleanBuilder b = new BooleanBuilder();
        if (amount != null) {
            b.and(Q_DEPOSIT.amountMin.loe(amount));
            b.and(Q_DEPOSIT.amountMax.goe(amount));
        }

        if (term != null) {
            b.and(Q_DEPOSIT.term.eq(term));
        }

        if (rate != null) {
            b.and(Q_DEPOSIT.rate.loe(rate));
        }

        return b;
    }

    private Predicate buildQDepositMaximumRatePredicateBy(Integer amount, Integer term) {
        return new BooleanBuilder()
                .and(Q_DEPOSIT.rate.eq(JPAExpressions
                        .select(Q_DEPOSIT.rate.max())
                        .from(Q_DEPOSIT)
                        .where(buildQDepositRateLessOrEqualPredicateBy(amount, term, null))
                ));
    }

}
