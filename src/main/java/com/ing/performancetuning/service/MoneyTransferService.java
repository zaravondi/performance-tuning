package com.ing.performancetuning.service;

import com.ing.performancetuning.contracts.MoneyTransferRequest;
import com.ing.performancetuning.model.Account;
import com.ing.performancetuning.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyTransferService {

    @Autowired
    private AccountRepository accountRepository;

    public void transferMoney(MoneyTransferRequest request) {
        // Para transferi işlemleri burada gerçekleştirilir

        Account senderAccount = accountRepository.findByAccountNumber(request.getSenderAccountNumber());
        Account receiverAccount = accountRepository.findByAccountNumber(request.getReceiverAccountNumber());

        if (senderAccount == null || receiverAccount == null) {
            throw new IllegalArgumentException("Invalid account numbers.");
        }

        if (senderAccount.getBalance().compareTo(request.getAmount()) < 0) {
            throw new IllegalArgumentException("Insufficient balance.");
        }

        // Para transferi işlemi
        senderAccount.setBalance(senderAccount.getBalance().subtract(request.getAmount()));
        receiverAccount.setBalance(receiverAccount.getBalance().add(request.getAmount()));

        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);
    }
}
