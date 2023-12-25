package ru.cobp.backend.repository.currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.cobp.backend.model.currency.CurrencyRate;

@Repository
public interface CurrencyRatesRepository extends JpaRepository<CurrencyRate, Long>, QuerydslPredicateExecutor<CurrencyRate> {
}
