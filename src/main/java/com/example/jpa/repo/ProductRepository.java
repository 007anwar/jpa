package com.example.jpa.repo;

import com.example.jpa.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findByName(String name);

    List<Product> findByNameAndDesc(String name,String desc);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByDescContains(String des);

    List<Product> findByPriceBetween(Double price1,Double price2);

    List<Product> findByDescLike(String des);

    List<Product> findByIdIn(List<Integer> ids);

}
