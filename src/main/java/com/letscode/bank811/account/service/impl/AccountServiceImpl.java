package com.letscode.bank811.account.service.impl;

import com.letscode.bank811.account.client.GetUserInfoClient;
import com.letscode.bank811.account.dto.AccountRequest;
import com.letscode.bank811.account.dto.AccountResponse;
import com.letscode.bank811.account.dto.AccountUser;
import com.letscode.bank811.account.model.Account;
import com.letscode.bank811.account.repository.AccountRepository;
import com.letscode.bank811.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    GetUserInfoClient getUserInfoClient;

    @Override
    public AccountUser create(Integer userId, AccountRequest accountRequest) {
        Account account = new Account(accountRequest);
        account.setUserId(userId);
        accountRepository.save(account);

        var user = getUserInfoClient.execute(userId);

        return new AccountUser(account, user);
    }

    @Override
    public Page<AccountResponse> getAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "agency");

        return new PageImpl<>(
            AccountResponse.toResponse(accountRepository.findAll(pageRequest).getContent()),
            pageRequest,
            accountRepository.count());
    }

    @Override
    public AccountUser getById(Integer id) {
        var account = accountRepository.findById(id).orElseThrow();
        var user = getUserInfoClient.execute(account.getUserId());

        return new AccountUser(account, user);
    }

    @Override
    public AccountResponse update(AccountRequest accountRequest, Integer id) {
        var account = accountRepository.findById(id).orElseThrow();

        account.setNumber(accountRequest.getNumber());
        account.setAgency(accountRequest.getAgency());
        account.setBalance(accountRequest.getBalance());
        account.setAccountType(accountRequest.getAccountType());

        return new AccountResponse(accountRepository.save(account));
    }

    @Override
    public void delete(Integer id) { accountRepository.deleteById(id); }
}
