package com.example.jpa.repo;

import com.example.jpa.entity.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends CrudRepository<BankAccount,Integer> {
}
