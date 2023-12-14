package ru.cobp.backend.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cobp.backend.bank.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

}
