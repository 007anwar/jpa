package com.example.jpa;

import com.example.jpa.entity.Product;
import com.example.jpa.repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class FInderDemo {
    private final ProductRepository productRepository;

    @Autowired
    public FInderDemo(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
}
