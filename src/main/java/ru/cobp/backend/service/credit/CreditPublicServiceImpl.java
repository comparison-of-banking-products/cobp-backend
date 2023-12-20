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
import ru.cobp.backend.dto.credit.NewCreditDto;
import ru.cobp.backend.exception.IncorrectPaymentTypeException;
import ru.cobp.backend.exception.NotFoundException;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.credit.Credit;
import ru.cobp.backend.model.credit.QCredit;
import ru.cobp.backend.model.currency.Currency;
import ru.cobp.backend.repository.credit.CreditRepository;
import ru.cobp.backend.service.bank.BankService;
import ru.cobp.backend.service.currency.CurrencyService;

import java.util.List;

import static ru.cobp.backend.common.Utils.toList;
import static ru.cobp.backend.dto.credit.CreditMapper.paymentTypeConverter;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CreditPublicServiceImpl implements CreditPublicService {

    private static final QCredit Q_CREDIT = QCredit.credit;

    private final CreditRepository creditRepository;

    private final CurrencyService currencyService;

    private final BankService bankService;

    @Override
    public List<Credit> getAll(CreditParams params) {
        Currency currency = new Currency();
        if (params.getCurrencyNum() != null) {
            currency = currencyService.getById(params.getCurrencyNum());
        }
        Predicate p = buildQCreditPredicateByParams(params, currency);
        Sort s = Sort.by("rate").ascending();
        return toList(creditRepository.findAll(p, s));
    }

    @Override
    public Credit getById(long id) {
        return creditRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Credit with id = " + id + " was not found"));
    }

    @Override
    public Credit create(NewCreditDto newCreditDto) {
        Bank bank = bankService.getByBic(newCreditDto.getBanksBic());
        Currency currency = currencyService.getById(newCreditDto.getCurrencyNum());
        Credit credit = CreditMapper.toCredit(newCreditDto, bank, currency);
        return creditRepository.save(credit);
    }

    @Override
    public Credit update(Long id, CreditDto creditDto) {
        Credit credit = creditRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Credit with id = " + id + " was not found"));
        if (creditDto.getIsActive() != null) {
            credit.setIsActive(creditDto.getIsActive());
        }
        if (creditDto.getBanksBic() != null) {
            credit.setBank(bankService.getByBic(creditDto.getBanksBic()));
        }
        if (creditDto.getName() != null) {
            credit.setName(creditDto.getName());
        }
        if (creditDto.getProductUrl() != null) {
            credit.setProductUrl(creditDto.getProductUrl());
        }
        if (creditDto.getCurrencyNum() != null) {
            credit.setCurrency(currencyService.getById(creditDto.getCurrencyNum()));
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

    private Predicate buildQCreditPredicateByParams(CreditParams params, Currency currency) {
        try {
            BooleanBuilder builder = new BooleanBuilder();
            if (params.getIsActive() != null) {
                builder.and(Q_CREDIT.isActive.eq(params.getIsActive()));
            }
            if (params.getCurrencyNum() != null) {
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
            if (!params.getPaymentType().isBlank()) {
                builder.and(Q_CREDIT.paymentType.eq(paymentTypeConverter
                        .convertToEntityAttribute((params.getPaymentType()))));
            }
            return builder;
        } catch (IllegalArgumentException e) {
            throw new IncorrectPaymentTypeException("Incorrect payment type: " + params.getPaymentType());
        }
    }

}
