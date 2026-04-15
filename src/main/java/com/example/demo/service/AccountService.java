package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccount(long accountId);
    AccountDto deposit(long accountid, double amount);
    AccountDto withdraw(long accountid, double amount);
    List<AccountDto> getAllAccounts();
    void deleteAccount(long id);
}
