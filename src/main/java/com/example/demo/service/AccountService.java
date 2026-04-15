package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.entity.Account;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccount(long accountId);
}
