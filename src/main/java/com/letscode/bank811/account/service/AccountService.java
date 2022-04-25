package com.letscode.bank811.account.service;

import com.letscode.bank811.account.dto.AccountRequest;
import com.letscode.bank811.account.dto.AccountResponse;
import com.letscode.bank811.account.dto.AccountUser;
import org.springframework.data.domain.Page;

public interface AccountService {

    AccountUser create(Integer usuarioId, AccountRequest accountRequest);

    Page<AccountResponse> getAll(int page, int size);

    AccountUser getById(Integer id);

    AccountResponse update(AccountRequest accountRequest, Integer id);

    void delete(Integer id);
}
