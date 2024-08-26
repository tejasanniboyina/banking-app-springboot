package com.teja.banking.repository;

import com.teja.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AccountRepo extends JpaRepository<Account, Long> {

}
