package com.teja.banking.service;

import com.teja.banking.dto.AccountDto;


public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);
}
