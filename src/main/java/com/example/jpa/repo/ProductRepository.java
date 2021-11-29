package com.example.jpa.repo;

import com.example.jpa.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findByName(String name);

    List<Product> findByNameAndDesc(String name,String desc);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByDescContains(String des);

    List<Product> findByPriceBetween(Double price1,Double price2);

    List<Product> findByDescLike(String des);

    List<Product> findByDescLike(String des, Pageable pageable);

    List<Product> findByIdIn(List<Integer> ids);

    @Query(nativeQuery = true,value = "CALL GetAllProducts")
    List<Product> getAllProducts();

    @Query(nativeQuery = true,value = "CALL GetAllProductsByPrice (:price_in)")
    List<Product> getAllProducts(double price_in);

}
