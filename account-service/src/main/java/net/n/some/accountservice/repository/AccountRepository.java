package net.n.some.accountservice.repository;

import net.n.some.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<BankAccount,Long> {
}
