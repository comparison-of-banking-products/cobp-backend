package ru.cobp.backend.deposit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.cobp.backend.deposit.entity.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long>, QuerydslPredicateExecutor<Deposit> {
}
