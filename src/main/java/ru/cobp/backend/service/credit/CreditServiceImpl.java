package ru.cobp.backend.service.credit;

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
import ru.cobp.backend.common.Utils;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditParams;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.exception.NotFoundException;
import ru.cobp.backend.mapper.CreditMapper;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.credit.QCredit;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.repository.credit.CreditRepository;
import ru.cobp.backend.service.bank.BankService;
import ru.cobp.backend.service.currency.CurrencyService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private static final QCredit Q_CREDIT = QCredit.credit;

    private final CreditRepository creditRepository;

    private final CurrencyService currencyService;

    private final BankService bankService;

    private final CreditMapper creditMapper;

    @Override
    public Page<Credit> getAllMinimumRateCreditPage(
            int amount,
            int term,
            Boolean creditOnline,
            Boolean onlineApprove,
            Boolean collateral,
            List<String> bics,
            Pageable pageable
    ) {
        Predicate p = buildQDepositMinimumRatePredicateBy(amount, term, creditOnline, onlineApprove, collateral, bics);
        return creditRepository.findAll(p, pageable);
    }

    @Override
    public List<Credit> getAll(CreditParams params, int page, int size) {
        Predicate p = buildQCreditPredicateByParams(params);
        Pageable pageable = PageRequest.of(page, size, Sort.by("rate").ascending());
        return Utils.toList(creditRepository.findAll(p, pageable));
    }

    @Override
    public Credit getById(long id) {
        return creditRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Credit with id = " + id + " was not found"));
    }

    @Override
    public Credit create(NewCreditDto newCreditDto) {
        Bank bank = bankService.getBankByBicOrThrowException(newCreditDto.getBankBic());
        Currency currency = currencyService.getById(newCreditDto.getCurrencyNum());
        Credit credit = creditMapper.toCredit(newCreditDto);
        credit.setBank(bank);
        credit.setCurrency(currency);
        return creditRepository.save(credit);
    }

    @Override
    public Credit update(Long id, CreditDto creditDto) {
        Credit credit = getById(id);
        updateCredit(credit, creditDto);
        return creditRepository.save(credit);
    }

    @Override
    public void delete(Long id) {
        if (creditRepository.findById(id).isPresent()) {
            creditRepository.deleteById(id);
        } else {
            throw new NotFoundException("Credit with id = " + id + " was not found");
        }
    }

    private Predicate buildQDepositMinimumRatePredicateBy(
            int amount, int term, Boolean creditOnline, Boolean onlineApprove, Boolean collateral, List<String> bics
    ) {
        BooleanBuilder builder = new BooleanBuilder()
                .and(Q_CREDIT.rate.goe(JPAExpressions
                        .select(Q_CREDIT.rate.min())
                        .from(Q_CREDIT)
                ))
                .and(Q_CREDIT.amountMin.loe(amount))
                .and(Q_CREDIT.amountMax.goe(amount))
                .and(Q_CREDIT.term.eq(term));

        if (creditOnline != null) {
            builder.and((Q_CREDIT.creditOnline.eq(creditOnline)));
        }

        if (onlineApprove != null) {
            builder.and((Q_CREDIT.onlineApprove.eq(onlineApprove)));
        }

        if (collateral != null) {
            builder.and((Q_CREDIT.collateral.eq(collateral)));
        }

        if (!bics.isEmpty()) {
            builder.and((Q_CREDIT.bank.bic.in(bics)));
        }

        return builder;
    }

    private Predicate buildQCreditPredicateByParams(CreditParams params) {
        BooleanBuilder builder = new BooleanBuilder();
        if (params.getIsActive() != null) {
            builder.and(Q_CREDIT.isActive.eq(params.getIsActive()));
        }
        if (params.getCurrencyNum() != null) {
            builder.and(Q_CREDIT.currency.eq(currencyService.getById(params.getCurrencyNum())));
        }
        if (params.getMinAmount() != null) {
            builder.and(Q_CREDIT.amountMin.loe(params.getMinAmount()));
        }
        if (params.getMaxAmount() != null) {
            builder.and(Q_CREDIT.amountMax.goe(params.getMaxAmount()));
        }
        if (params.getMinPeriod() != null) {
            builder.and(Q_CREDIT.term.loe(params.getMinPeriod()));
        }
        if (params.getMaxPeriod() != null) {
            builder.and(Q_CREDIT.term.goe(params.getMaxPeriod()));
        }
        if (params.getRate() != null) {
            builder.and(Q_CREDIT.rate.eq(params.getRate()));
        }
        if (params.getPaymentType() != null) {
            builder.and(Q_CREDIT.paymentType.eq(params.getPaymentType()));
        }
        if (params.getCreditOnline() != null) {
            builder.and(Q_CREDIT.creditOnline.eq(params.getCreditOnline()));
        }
        if (params.getOnlineApprove() != null) {
            builder.and(Q_CREDIT.onlineApprove.eq(params.getOnlineApprove()));
        }
        if (params.getCollateral() != null) {
            builder.and(Q_CREDIT.collateral.eq(params.getCollateral()));
        }
        return builder;

    }

    private void updateCredit(Credit credit, CreditDto creditDto) {
        if (creditDto.getIsActive() != null) {
            credit.setIsActive(creditDto.getIsActive());
        }
        if (creditDto.getName() != null) {
            credit.setName(creditDto.getName());
        }
        if (creditDto.getProductUrl() != null) {
            credit.setProductUrl(creditDto.getProductUrl());
        }
        if (creditDto.getRate() != null) {
            credit.setRate(creditDto.getRate());
        }
        if (creditDto.getMinAmount() != null) {
            credit.setAmountMin(creditDto.getMinAmount());
        }
        if (creditDto.getMaxAmount() != null) {
            credit.setAmountMax(credit.getAmountMax());
        }
        if (creditDto.getTerm() != null) {
            credit.setTerm(creditDto.getTerm());
        }
        if (creditDto.getCreditOnline() != null) {
            credit.setCreditOnline(creditDto.getCreditOnline());
        }
        if (creditDto.getOnlineApprove() != null) {
            credit.setOnlineApprove(creditDto.getOnlineApprove());
        }
        if (creditDto.getCollateral() != null) {
            credit.setCollateral(creditDto.getCollateral());
        }
    }

}
