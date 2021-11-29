package com.example.jpa.repo;

import com.example.jpa.entity.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepo extends CrudRepository<Image,Integer> {
}
