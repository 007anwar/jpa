package com.example.jpa.repo;

import com.example.jpa.entity.Emp;
import com.example.jpa.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends CrudRepository<Emp,Integer> {
}
