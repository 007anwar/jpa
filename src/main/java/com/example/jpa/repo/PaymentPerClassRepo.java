package com.example.jpa.repo;

import com.example.jpa.entity.Payment;
import com.example.jpa.entity.PaymentPerClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentPerClassRepo extends CrudRepository<PaymentPerClass,Integer> {
}
