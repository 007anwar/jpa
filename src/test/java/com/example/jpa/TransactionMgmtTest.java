package com.example.jpa;

import com.example.jpa.service.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransactionMgmtTest {
private final BankAccountService bankAccountService;

    @Autowired
    public TransactionMgmtTest(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }


    @Test
    public void tranferAmmont()
    {
        bankAccountService.transfer(1000);
    }

}

