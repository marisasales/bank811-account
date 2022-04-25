package com.letscode.bank811.account.controller;

import com.letscode.bank811.account.dto.AccountRequest;
import com.letscode.bank811.account.dto.AccountResponse;
import com.letscode.bank811.account.dto.AccountUser;
import com.letscode.bank811.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountUser create(@PathVariable("id") Integer id, @RequestBody AccountRequest accountRequest) {
        return accountService.create(id, accountRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<AccountResponse> getAll(
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "3") int size) {
        return accountService.getAll(page, size);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountUser getById(@PathVariable Integer id) {
        return accountService.getById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountResponse update(@PathVariable Integer id, @RequestBody AccountRequest accountRequest) {
        return accountService.update(accountRequest, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) { accountService.delete(id); }
}
