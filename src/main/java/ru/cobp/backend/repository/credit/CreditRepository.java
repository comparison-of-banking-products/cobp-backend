package ru.cobp.backend.repository.credit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import ru.cobp.backend.model.credit.Credit;

public interface CreditRepository extends JpaRepository<Credit, Long>, QuerydslPredicateExecutor<Credit> {
}
