package com.ing.performancetuning.repository;

import com.ing.performancetuning.model.Account;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccountRepository {
    private Map<String, Account> accounts;

    public AccountRepository() {
        this.accounts = new HashMap<>();

        Account account1 = new Account();
        account1.setAccountNumber("123456789");
        account1.setBalance(new BigDecimal("1000"));
        accounts.put(account1.getAccountNumber(), account1);

        Account account2 = new Account();
        account2.setAccountNumber("987654321");
        account2.setBalance(new BigDecimal("500"));
        accounts.put(account2.getAccountNumber(), account2);
    }

    public Account findByAccountNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void save(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }
}
