package ru.cobp.backend.credit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cobp.backend.credit.entity.Credit;

public interface CreditRepository extends JpaRepository<Credit, Long> {

}
