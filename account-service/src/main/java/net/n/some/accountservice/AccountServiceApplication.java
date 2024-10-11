package net.n.some.accountservice;

import net.n.some.accountservice.entities.BankAccount;
import net.n.some.accountservice.entities.enums.AccountType;
import net.n.some.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
        return args -> {
            List<BankAccount> bankAccounts = List.of(
                    BankAccount.builder()
                            .balance(12000)
                            .currency("FRCFA")
                            .createDate(LocalDate.now())
                            .customerId(1L)
                            .type(AccountType.CURRENT_ACCOUNT)
                            .build(),
                    BankAccount.builder()
                            .balance(13000)
                            .currency("FRCFA")
                            .createDate(LocalDate.now())
                            .customerId(2L)
                            .type(AccountType.SAVINGS_ACCOUNT)
                            .build(),
                    BankAccount.builder()
                            .balance(14000)
                            .currency("FRCFA")
                            .createDate(LocalDate.now())
                            .customerId(3L)
                            .type(AccountType.SAVINGS_ACCOUNT)
                            .build()
            );
            accountRepository.saveAll(bankAccounts);
        };
    }

}
