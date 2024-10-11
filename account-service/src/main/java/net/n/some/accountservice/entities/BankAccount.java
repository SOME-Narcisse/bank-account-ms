package net.n.some.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.n.some.accountservice.entities.enums.AccountType;
import net.n.some.accountservice.models.Customer;

import java.time.LocalDate;

@Entity
@Getter @Setter @Builder
@ToString @AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double balance;
    private LocalDate createDate;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

}
