package com.letscode.bank811.account.dto;

import com.letscode.bank811.account.model.Account;
import com.letscode.bank811.account.model.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class AccountResponse {

    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private AccountType accountType;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    public AccountResponse(Account account) {
        this.number = account.getNumber();
        this.agency = account.getAgency();
        this.balance = account.getBalance();
        this.accountType = account.getAccountType();
        this.creationDate = account.getCreationDate();
        this.updateDate = account.getUpdateDate();
    }

    public static List<AccountResponse> toResponse(List<Account> accounts) {
        return accounts.stream().map(AccountResponse::new).collect(Collectors.toList());
    }
}
