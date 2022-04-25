package com.letscode.bank811.account.model;

import com.letscode.bank811.account.dto.AccountRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "account")
@Entity
@Getter @Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "number", nullable = false, unique = true)
    private Integer number;

    @Column(name = "agency", nullable = false)
    private Integer agency;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "account_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "creation_date")
    @CreatedDate
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    @LastModifiedDate
    private LocalDateTime updateDate;

    public Account(AccountRequest accountRequest) {
        this.number = accountRequest.getNumber();
        this.agency = accountRequest.getAgency();
        this.balance = accountRequest.getBalance();
        this.accountType = accountRequest.getAccountType();
    }
}
