package ru.cobp.backend.service.deposit;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.model.deposit.QDeposit;
import ru.cobp.backend.repository.deposit.DepositRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService {

    private static final QDeposit Q_DEPOSIT = QDeposit.deposit;

    private final DepositRepository depositRepository;

    @Override
    public Deposit findMaximumRateDepositByAmountAndTerm(int amount, int term) {
        Predicate p = buildQDepositPredicateByAmountAndTerm(amount, term);
        Sort s = Sort.by(Sort.Direction.DESC, "rate");
        List<Deposit> deposits = toList(depositRepository.findAll(p, s));
        return deposits.get(0);
    }

    private List<Deposit> toList(Iterable<Deposit> iterable) {
        return StreamSupport
                .stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    private Predicate buildQDepositPredicateByAmountAndTerm(int amount, int term) {
        return new BooleanBuilder()
                .and(Q_DEPOSIT.amountMin.loe(amount))
                .and(Q_DEPOSIT.amountMax.goe(amount))
                .and(Q_DEPOSIT.term.eq(term));
    }

}
