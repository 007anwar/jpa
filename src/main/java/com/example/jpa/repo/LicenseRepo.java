package com.example.jpa.repo;

import com.example.jpa.entity.License;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepo extends CrudRepository<License,Integer> {
}
