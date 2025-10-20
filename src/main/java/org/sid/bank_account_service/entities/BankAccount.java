package org.sid.bank_account_service.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.bank_account_service.enums.AccountType;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {

    @Id
    private String id;  // e.g., UUID string

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private Double balance;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    private String currency;

    @ManyToOne
    private Customer customer;
}