package com.example.jpa.serviceimpl;

import com.example.jpa.entity.BankAccount;
import com.example.jpa.repo.BankRepo;
import com.example.jpa.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.invoke.LambdaMetafactory;
@Service
public class BankAccountServiceImpl implements BankAccountService {
    private final BankRepo bankRepo;

    @Autowired
    public BankAccountServiceImpl(BankRepo bankRepo) {
        this.bankRepo = bankRepo;
    }

    @Override
    @Transactional
    public void transfer(int amount) {
        BankAccount obamasAccount = bankRepo.findById(1).get();
        BankAccount trumpsAccount = bankRepo.findById(2).get();
        obamasAccount.setBalance(obamasAccount.getBalance()- amount);
        bankRepo.save(obamasAccount);
        if(amount==1000)
        throw new RuntimeException("Error in transfering the bal");
        trumpsAccount.setBalance(trumpsAccount.getBalance()+amount);
        bankRepo.save(trumpsAccount);
    }
}
