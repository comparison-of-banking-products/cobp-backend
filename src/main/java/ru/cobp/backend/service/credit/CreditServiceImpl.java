package ru.cobp.backend.service.credit;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.common.Utils;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.credit.QCredit;
import ru.cobp.backend.repository.credit.CreditRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private static final QCredit Q_CREDIT = QCredit.credit;

    private final CreditRepository creditRepository;

    @Override
    public List<Credit> findAllMinimumRateCredits(int amount, int term, Pageable pageable) {
        Predicate p = buildQDepositMinimumRatePredicateBy(amount, term);
        Iterable<Credit> credits = creditRepository.findAll(p, pageable);
        return Utils.toList(credits);
    }

    private Predicate buildQDepositMinimumRatePredicateBy(int amount, int term) {
        return new BooleanBuilder()
                .and(Q_CREDIT.rate.goe(JPAExpressions
                        .select(Q_CREDIT.rate.min())
                        .from(Q_CREDIT)
                ))
                .and(Q_CREDIT.amountMin.loe(amount))
                .and(Q_CREDIT.amountMax.goe(amount))
                .and(Q_CREDIT.term.eq(term));
    }

}
