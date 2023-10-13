package com.multipolar.bootcamp.account.controller;


import com.multipolar.bootcamp.account.domain.Account;
import com.multipolar.bootcamp.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //input data
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createOrUpdateAccount(account); }

    //display all data
    @GetMapping
    public List<Account> getAllAccount(){
        return accountService.getAllAccount();
    }

    //display data by id
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable String id){
        Optional<Account> account = accountService.getAccountByID(id);
        return account.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //edit data
    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable String id, @RequestBody Account account){
        account.setId(id);
        return  accountService.createOrUpdateAccount(account);
    }

    //delete data
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable String id){
        accountService.deleteAccountById(id);
        return ResponseEntity.notFound().build();
    }

}
