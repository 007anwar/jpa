package com.example.jpa.repo;

import com.example.jpa.entity.PaymentPerSubClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentPerSubClassRepo extends CrudRepository<PaymentPerSubClass,Integer> {
}
