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
import ru.cobp.backend.dto.calculator.DepositCalculatorParams;
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
    public List<Deposit> findAllDeposits(
            Integer minAmount,
            Integer maxAmount,
            Integer minTerm,
            Integer maxTerm,
            Double minRate,
            Double maxRate,
            Boolean capitalization,
            Boolean replenishment,
            Boolean partialWithdrawal,
            Pageable pageable
    ) {
        Predicate p = buildQDepositPredicateBy(
                minAmount, maxAmount, minTerm, maxTerm, minRate, maxRate, capitalization, replenishment,
                partialWithdrawal
        );
        return depositRepository.findAll(p, pageable).toList();
    }

    @Override
    public Page<Deposit> getAllMaximumRateDepositPage(DepositCalculatorParams params) {
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

    private Predicate buildQDepositMaximumRatePredicateBy(DepositCalculatorParams params) {
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

    private Predicate buildQDepositPredicateBy(
            Integer minAmount, Integer maxAmount, Integer minTerm, Integer maxTerm, Double minRate, Double maxRate,
            Boolean capitalization, Boolean replenishment, Boolean partialWithdrawal
    ) {
        BooleanBuilder builder = new BooleanBuilder();

        if (minAmount != null) {
            builder.and(Q_DEPOSIT.amountMin.loe(minAmount));
        }

        if (maxAmount != null) {
            builder.and(Q_DEPOSIT.amountMax.goe(maxAmount));
        }

        if (minTerm != null) {
            builder.and(Q_DEPOSIT.term.goe(minTerm));
        }

        if (maxTerm != null) {
            builder.and(Q_DEPOSIT.term.loe(maxTerm));
        }

        if (minRate != null) {
            builder.and(Q_DEPOSIT.rate.goe(minRate));
        }

        if (maxRate != null) {
            builder.and(Q_DEPOSIT.rate.loe(maxRate));
        }

        if (capitalization != null) {
            builder.and(Q_DEPOSIT.capitalization.eq(capitalization));
        }

        if (replenishment != null) {
            builder.and(Q_DEPOSIT.replenishment.eq(replenishment));
        }

        if (partialWithdrawal != null) {
            builder.and(Q_DEPOSIT.partialWithdrawal.eq(partialWithdrawal));
        }

        return builder;
    }

}
