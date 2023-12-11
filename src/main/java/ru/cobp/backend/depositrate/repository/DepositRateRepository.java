package ru.cobp.backend.depositrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.cobp.backend.depositrate.entity.DepositRate;

@Repository
public interface DepositRateRepository extends JpaRepository<DepositRate, Long>, QuerydslPredicateExecutor<DepositRate> {
}
