package com.example.jpa;

import com.example.jpa.entity.Product;
import com.example.jpa.repo.ProductRepository;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class FInderDemo {
    private final ProductRepository productRepository;
    private final EntityManager entityManager;
      @Autowired
    public FInderDemo(ProductRepository productRepository, EntityManager entityManager) {
        this.productRepository = productRepository;
        this.entityManager = entityManager;
    }


    @Test
    public void testFindByName()
    {
        List<Product> products = productRepository.findByName("logitech");
        products.forEach(product -> System.out.println(product));
    }

    @Test
    public void testFindByNameAndDesd()
    {
        List<Product> products = productRepository.findByNameAndDesc("logitech","mouse");
        products.forEach(product -> System.out.println("RESULT : "+product));
    }

    @Test
    public void testFindByPriceGreaterThan()
    {
        List<Product> products = productRepository.findByPriceGreaterThan(1000d);
        products.forEach(product -> System.out.println("RESULT : "+product));
    }

    @Test
    public void testFindByDescContains()
    {
        List<Product> products = productRepository.findByDescContains("po");
        products.forEach(product -> System.out.println("RESULT : "+product));
    }

    @Test
    public void testFindByPriceBetween()
    {
        List<Product> products = productRepository.findByPriceBetween(1d,999d);
        products.forEach(product -> System.out.println("RESULT : "+product));
    }

    @Test
    public void testFindByDescLike()
    {
        List<Product> products = productRepository.findByDescLike("%we%");
        products.forEach(product -> System.out.println("RESULT : "+product));
    }

    @Test
    public void testFindByIdIn()
    {
        List<Product> products = productRepository.findByIdIn(List.of(2,3,7));
        products.forEach(product -> System.out.println("RESULT : "+product));
    }

    @Test
     @Transactional//to enable level 1 cache, method should be marked with transactional
    public void testCaching()
    {
        System.out.println("FINDING");
        Optional<Product> byId1 = productRepository.findById(1);
        Session unwrap = entityManager.unwrap(Session.class);
        unwrap.evict(byId1.get());//used to remove object from the cache
        System.out.println("FINDING AGAIN");
        Optional<Product> byId = productRepository.findById(1);
        byId.ifPresent(product -> {
            System.out.println(product);
        });
    }

    @Test
    public void getAllProd()
    {
        List<Product> allProducts = productRepository.getAllProducts();
        allProducts.forEach(product -> System.out.println(product));
    }

    @Test
    public void getAllProdByPrice()
    {
        List<Product> allProducts = productRepository.getAllProducts(8000);
        allProducts.forEach(product -> System.out.println(product));
    }
}
