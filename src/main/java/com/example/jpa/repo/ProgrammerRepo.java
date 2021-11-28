package com.example.jpa.repo;

import com.example.jpa.assocations.entity.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepo extends CrudRepository<Programmer,Integer> {
}
