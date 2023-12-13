package ru.cobp.backend.service.credit.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.credit.QCredit;
import ru.cobp.backend.repository.credit.CreditRepository;
import ru.cobp.backend.service.credit.CreditService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private static final QCredit Q_CREDIT = QCredit.credit;

    private final CreditRepository creditRepository;

    @Override
    public Credit findMinimumRateCreditByAmountAndTerm(int amount, int term) {
        Predicate p = buildQCreditPredicateByAmountAndTerm(amount, term);
        Sort s = Sort.by("rate").ascending();
        List<Credit> credits = toList(creditRepository.findAll(p, s));
        return credits.get(0);
    }

    private List<Credit> toList(Iterable<Credit> iterable) {
        return StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    private Predicate buildQCreditPredicateByAmountAndTerm(int amount, int term) {
        return new BooleanBuilder()
                .and(Q_CREDIT.amountMin.loe(amount))
                .and(Q_CREDIT.amountMax.goe(amount))
                .and(Q_CREDIT.term.eq(term));
    }

}
