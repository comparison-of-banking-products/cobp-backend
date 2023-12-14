package ru.cobp.backend.repository.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cobp.backend.model.bank.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

}
