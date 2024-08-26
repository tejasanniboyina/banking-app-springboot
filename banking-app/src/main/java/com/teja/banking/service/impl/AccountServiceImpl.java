package com.teja.banking.service.impl;

import com.teja.banking.dto.AccountDto;
import com.teja.banking.entity.Account;
import com.teja.banking.mapper.AccountMapper;
import com.teja.banking.repository.AccountRepo;
import com.teja.banking.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {



    private AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id){
        Account account =accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does  not exit. . . "));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account =accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account does  not exit. . . "));

      double total =   account.getBalance() + amount;
      account.setBalance(total);
      Account savedAccount = accountRepo.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
