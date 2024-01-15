package ru.cobp.backend.service.bank;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cobp.backend.dto.bank.BankSort;
import ru.cobp.backend.exception.DuplicateException;
import ru.cobp.backend.exception.ExceptionMessage;
import ru.cobp.backend.exception.NotFoundException;
import ru.cobp.backend.model.bank.Bank;
import ru.cobp.backend.model.bank.QBank;
import ru.cobp.backend.model.credit.QCredit;
import ru.cobp.backend.model.deposit.QDeposit;
import ru.cobp.backend.repository.bank.BankRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {
    private static final QBank Q_BANK = QBank.bank;
    private static final QCredit Q_CREDIT = QCredit.credit;
    private static final QDeposit Q_DEPOSIT = QDeposit.deposit;
    private final BankRepository bankRepository;

    @Override
    @Transactional
    public Bank create(Bank newBank) {
        checkIfBankExistsByBic(newBank.getBic());
        return bankRepository.save(newBank);
    }

    @Override
    @Transactional
    public Bank update(String bic, Bank updateBank) {
        Bank bank = getBankByBicOrThrowException(bic);

        if (updateBank.getName() != null) {
            bank.setName(updateBank.getName());
        }
        if (updateBank.getLegalEntity() != null) {
            bank.setLegalEntity(updateBank.getLegalEntity());
        }
        if (updateBank.getDescription() != null) {
            bank.setDescription(updateBank.getDescription());
        }
        if (updateBank.getLogo() != null) {
            bank.setLogo(updateBank.getLogo());
        }
        if (updateBank.getUrl() != null) {
            bank.setUrl(updateBank.getUrl());
        }

        return bankRepository.save(bank);
    }

    @Override
    public Bank getBankByBicOrThrowException(String bic) {
        return bankRepository.findById(bic).orElseThrow(
                () -> new NotFoundException(
                        String.format(ExceptionMessage.BANK_NOT_FOUND, bic)
                ));
    }

    @Override
    @Transactional
    public void deleteByBic(String bic) {
        getBankByBicOrThrowException(bic);
        bankRepository.deleteById(bic);
    }

    @Override
    public List<Bank> getAll(BankSort sort, List<String> bics) {
        Predicate p = buildQBankPredicateBy(sort, bics);
        return (List<Bank>) bankRepository.findAll(p);
    }

    private Predicate buildQBankPredicateBy(BankSort sort, List<String> bics) {
        BooleanBuilder builder = new BooleanBuilder();

        if (sort != null) {
            Predicate p = switch (sort) {
                case CREDITS -> Q_BANK.in(JPAExpressions
                        .select(Q_CREDIT.bank)
                        .from(Q_CREDIT)
                        .where(Q_CREDIT.bank.isNotNull()));

                case DEPOSITS -> Q_BANK.in(JPAExpressions
                        .select(Q_DEPOSIT.bank)
                        .from(Q_DEPOSIT)
                        .where(Q_DEPOSIT.bank.isNotNull()));
            };
            builder.and(p);
        }

        if (!bics.isEmpty()) {
            builder.and((Q_BANK.bic.in(bics)));
        }

        return builder;
    }

    private void checkIfBankExistsByBic(String bic) {
        if (bankRepository.findById(bic).isPresent()) {
            throw new DuplicateException(
                    String.format(ExceptionMessage.DUPLICATE_EXCEPTION, Bank.class)
            );
        }
    }
}
