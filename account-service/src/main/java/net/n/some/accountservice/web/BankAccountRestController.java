package net.n.some.accountservice.web;

import lombok.AllArgsConstructor;
import net.n.some.accountservice.clients.CustomerRestClient;
import net.n.some.accountservice.entities.BankAccount;
import net.n.some.accountservice.models.Customer;
import net.n.some.accountservice.repository.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BankAccountRestController {
    private AccountRepository accountRepository;
    private CustomerRestClient customerRestClient;

    @GetMapping("/accounts")
    public List<BankAccount> getAllAccounts() {
        List<BankAccount> bankAccounts= accountRepository.findAll();
        bankAccounts.forEach(bankAccount -> {
            bankAccount.setCustomer(customerRestClient.findCustomeById(bankAccount.getCustomerId()));
        });
        return bankAccounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getAccountById(@PathVariable Long id) {
        BankAccount bankAccount = accountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomeById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }

    @PostMapping("/acciunts")
    public BankAccount createAccount(BankAccount account) {
        return accountRepository.save(account);
    }

    @PutMapping("/accounts")
    public BankAccount updateAccount(BankAccount account) {
        return accountRepository.save(account);
    }
}
