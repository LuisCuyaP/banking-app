package com.example.demo.controller;

import com.example.demo.dto.AccountDto;
import com.example.demo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("{accountId}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable long accountId){
        return new ResponseEntity<>(accountService.getAccount(accountId), HttpStatus.OK);
    }

    @PutMapping("{accountId}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable long accountId, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.deposit(accountId, amount);
        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("{accountId}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable long accountId, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(accountId, amount);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping()
    public ResponseEntity<List<AccountDto>> getAccounts(){
        List<AccountDto> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Delete account", HttpStatus.OK);
    }
}
