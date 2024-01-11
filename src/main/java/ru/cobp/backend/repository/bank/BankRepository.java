package ru.cobp.backend.repository.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.cobp.backend.model.bank.Bank;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>, QuerydslPredicateExecutor<Bank> {
    Optional<Bank> findByBic(String bic);

    void deleteByBic(String bic);
}
