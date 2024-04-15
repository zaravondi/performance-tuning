package com.ing.performancetuning.controller;

import com.ing.performancetuning.contracts.MoneyTransferRequest;
import com.ing.performancetuning.service.MoneyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/money-transfer")
public class MoneyTransferController {

    @Autowired
    private MoneyTransferService moneyTransferService;

    @PostMapping("/transferMoney")
    public ResponseEntity<String> transferMoney(@RequestBody MoneyTransferRequest request) {
        moneyTransferService.transferMoney(request);
        return ResponseEntity.ok("Money transfer successful.");
    }
}
