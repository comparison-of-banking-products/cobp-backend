package ru.cobp.backend.service.credit;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.common.Utils;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditParams;
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.exception.NotFoundException;
import ru.cobp.backend.exception.UnsupportedPaymentTypeException;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.credit.CreditList;
import ru.cobp.backend.model.credit.PaymentType;
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

    @Override
    public CreditList findAllMinimumRateCredits(int amount, int term, List<String> bics, Pageable pageable) {
        Predicate p = buildQDepositMinimumRatePredicateBy(amount, term, bics);
        Page<Credit> creditPage = creditRepository.findAll(p, pageable);
        List<Credit> credits = creditPage.hasContent()
                ? creditPage.getContent()
                : List.of();

        return new CreditList(credits, creditPage.getTotalElements());
    }

    @Override
    public List<Credit> getAll(CreditParams params, Pageable pageable) {
        Predicate p = buildQCreditPredicateByParams(params);
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
        Credit credit = toCredit(newCreditDto, bank, currency);
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

    private Predicate buildQDepositMinimumRatePredicateBy(int amount, int term, List<String> bics) {
        BooleanBuilder builder = new BooleanBuilder()
                .and(Q_CREDIT.rate.goe(JPAExpressions
                        .select(Q_CREDIT.rate.min())
                        .from(Q_CREDIT)
                ))
                .and(Q_CREDIT.amountMin.loe(amount))
                .and(Q_CREDIT.amountMax.goe(amount))
                .and(Q_CREDIT.term.eq(term));

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
        return builder;

    }

    private Credit toCredit(NewCreditDto newCreditDto, Bank bank, Currency currency) {
        return new Credit(null, bank, newCreditDto.getName(), newCreditDto.getProductUrl(),
                newCreditDto.getIsActive(), currency, newCreditDto.getMinAmount(), newCreditDto.getMaxAmount(),
                newCreditDto.getTerm(), newCreditDto.getRate(), toPaymentType(newCreditDto.getPaymentType()));
    }

    private PaymentType toPaymentType(String paymentType) {
        switch (paymentType) {
            case "Аннуитетный":
                return PaymentType.ANNUITY;
            case "Дифференцированный":
                return PaymentType.DIFFERENTIAL;
            default:
                throw new UnsupportedPaymentTypeException("Incorrect payment type");
        }
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
    }

}
