package com.ing.performancetuning.contracts;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MoneyTransferRequest {

    private String senderAccountNumber;
    private String receiverAccountNumber;
    private BigDecimal amount;

}
