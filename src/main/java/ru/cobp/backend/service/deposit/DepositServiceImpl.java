package ru.cobp.backend.service.deposit;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.dto.calculator.MaximumRateDepositParams;
import ru.cobp.backend.dto.deposit.DepositParams;
import ru.cobp.backend.model.deposit.Deposit;
import ru.cobp.backend.model.deposit.QDeposit;
import ru.cobp.backend.model.deposit.ScrapedDeposit;
import ru.cobp.backend.repository.deposit.DepositRepository;
import ru.cobp.backend.repository.deposit.ScrapedDepositRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DepositServiceImpl implements DepositService {

    private static final QDeposit Q_DEPOSIT = QDeposit.deposit;

    private final DepositRepository depositRepository;

    private final ScrapedDepositRepository scrapedDepositRepository;

    @Override
    public Page<Deposit> getAllDepositPage(DepositParams params) {
        Predicate p = buildQDepositPredicateBy(params);
        Pageable pageable = PageRequest.of(params.page(), params.size());
        return depositRepository.findAll(p, pageable);
    }

    @Override
    public Page<Deposit> getAllMaximumRateDepositPage(MaximumRateDepositParams params) {
        Predicate p = buildQDepositMaximumRatePredicateBy(params);
        Pageable pageable = PageRequest.of(
                params.page(), params.size(), Sort.sort(Deposit.class).by(Deposit::getRate).descending()
        );
        return depositRepository.findAll(p, pageable);
    }

    @Override
    public List<ScrapedDeposit> getAllScrapedDeposits() {
        return scrapedDepositRepository.findAll();
    }

    private Predicate buildQDepositMaximumRatePredicateBy(MaximumRateDepositParams params) {
        BooleanBuilder builder = new BooleanBuilder()
                .and(Q_DEPOSIT.rate.loe(JPAExpressions
                        .select(Q_DEPOSIT.rate.max())
                        .from(Q_DEPOSIT)
                ))
                .and(Q_DEPOSIT.amountMin.loe(params.amount()))
                .and(Q_DEPOSIT.amountMax.goe(params.amount()))
                .and(Q_DEPOSIT.term.eq(params.term()));

        if (params.capitalization() != null) {
            builder.and(Q_DEPOSIT.capitalization.eq(params.capitalization()));
        }

        if (params.replenishment() != null) {
            builder.and(Q_DEPOSIT.replenishment.eq(params.replenishment()));
        }

        if (params.partialWithdrawal() != null) {
            builder.and(Q_DEPOSIT.partialWithdrawal.eq(params.partialWithdrawal()));
        }

        if (!params.bics().isEmpty()) {
            builder.and((Q_DEPOSIT.bank.bic.in(params.bics())));
        }

        return builder;
    }

    private Predicate buildQDepositPredicateBy(DepositParams params) {
        BooleanBuilder builder = new BooleanBuilder();

        if (!params.bics().isEmpty()) {
            builder.and((Q_DEPOSIT.bank.bic.in(params.bics())));
        }

        if (params.isActive() != null) {
            builder.and(Q_DEPOSIT.isActive.eq(params.isActive()));
        }

        if (params.amountMin() != null) {
            builder.and(Q_DEPOSIT.amountMin.goe(params.amountMin()));
        }

        if (params.amountMax() != null) {
            builder.and(Q_DEPOSIT.amountMax.loe(params.amountMax()));
        }

        if (params.termMin() != null) {
            builder.and(Q_DEPOSIT.term.goe(params.termMin()));
        }

        if (params.termMax() != null) {
            builder.and(Q_DEPOSIT.term.loe(params.termMax()));
        }

        if (params.rateMin() != null) {
            builder.and(Q_DEPOSIT.rate.goe(params.rateMin()));
        }

        if (params.rateMax() != null) {
            builder.and(Q_DEPOSIT.rate.loe(params.rateMax()));
        }

        if (params.capitalization() != null) {
            builder.and(Q_DEPOSIT.capitalization.eq(params.capitalization()));
        }

        if (params.replenishment() != null) {
            builder.and(Q_DEPOSIT.replenishment.eq(params.replenishment()));
        }

        if (params.partialWithdrawal() != null) {
            builder.and(Q_DEPOSIT.partialWithdrawal.eq(params.partialWithdrawal()));
        }

        return builder;
    }

}
