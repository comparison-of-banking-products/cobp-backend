package ru.cobp.backend.repository.credit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.cobp.backend.model.credit.Credit;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long>, QuerydslPredicateExecutor<Credit> {
}
