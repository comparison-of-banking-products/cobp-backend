package ru.cobp.backend.service.credit;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.dto.credit.CreditDto;
import ru.cobp.backend.dto.credit.CreditMapper;
import ru.cobp.backend.dto.credit.CreditParams;
import ru.cobp.backend.exception.NotFoundException;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.credit.QCredit;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.repository.credit.CreditRepository;
import ru.cobp.backend.repository.currency.CurrencyRepository;

import java.util.List;

import static ru.cobp.backend.common.Utils.toList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CreditPublicServiceImpl implements CreditPublicService {

    private static final QCredit Q_CREDIT = QCredit.credit;

    private final CreditRepository creditRepository;

    private final CurrencyRepository currencyRepository;

    @Override
    public List<CreditDto> getAll(CreditParams params) {
        Currency currency = new Currency();
        if (params.getCurrenciesNum() != null) {
            currency = currencyRepository.findById(params.getCurrenciesNum()).orElseThrow(() ->
                    new NotFoundException("Currency with id = " + params.getCurrenciesNum() + " was not found"));
        }
        Predicate p = buildQCreditPredicateByParams(params, currency);
        Sort s = Sort.by("rate").ascending();
        List<Credit> credits = toList(creditRepository.findAll(p, s));
        return CreditMapper.toCreditDtoList(credits);
    }

    @Override
    public CreditDto getById(long id) {
        return CreditMapper.toCreditDto(creditRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Credit with id = " + id + " was not found")));
    }

    private Predicate buildQCreditPredicateByParams(CreditParams params, Currency currency) {
        BooleanBuilder builder = new BooleanBuilder();
        if (params.getIsActive() != null) {
            builder.and(Q_CREDIT.isActive.eq(params.getIsActive()));
        }
        if (params.getCurrenciesNum() != null) {
            builder.and(Q_CREDIT.currency.eq(currency));
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
        return builder;
    }

}
