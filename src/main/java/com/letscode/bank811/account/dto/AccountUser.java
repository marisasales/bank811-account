package com.letscode.bank811.account.dto;

import com.letscode.bank811.account.dto.client.UserInfo;
import com.letscode.bank811.account.model.Account;
import com.letscode.bank811.account.model.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter
public class AccountUser {

  private Integer number;
  private Integer agency;
  private BigDecimal balance;
  private AccountType accountType;
  private UserInfo userInfo;

  public AccountUser(Account account, UserInfo userInfo) {
    this.number = account.getNumber();
    this.agency = account.getAgency();
    this.balance = account.getBalance();
    this.accountType = account.getAccountType();
    this.userInfo = userInfo;
  }
}
