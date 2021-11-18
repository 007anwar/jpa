package com.example.jpa;

import com.example.jpa.entity.Product;
import com.example.jpa.repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;


/**
 * PageRequest.of()
 * takes page and size and optionally sort order can also be passed to it
 *
 * sort object can be created by using Sort class and invoking by() a static method on that object
 *
 * when complex sorting order is to be created then one should create Sort.order object serparately using
 *
 * new Sort.Order(direction,property); and the pass sort order objects to Sort.by();
 *
 * **/
@SpringBootTest
public class TestPagingAndSorting {
    private final ProductRepository productRepository;

    @Autowired
    public TestPagingAndSorting(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Test
    public void testFindAllPaging()
    {
        Sort sort = Sort.by(Sort.Direction.ASC, "name","desc");
        PageRequest page = PageRequest.of(0, 3,Sort.by(Sort.Direction.ASC, "name","desc"));
        Sort.Order name = new Sort.Order(Sort.Direction.DESC, "name");
        Sort.Order desc = new Sort.Order(Sort.Direction.ASC, "desc");
        Page<Product> allProducts = productRepository.findAll(PageRequest.of(0, 3,Sort.by(Sort.Direction.DESC, "name","desc")));
       allProducts.forEach(product -> System.out.println(product));

    }


    @Test
    public void testFindAllPagingOrder()
    {

        Sort sort = Sort.by(Sort.Direction.ASC, "name","desc");
        PageRequest page = PageRequest.of(0, 3,Sort.by(Sort.Direction.ASC, "name","desc"));
        Sort.Order name = new Sort.Order(Sort.Direction.DESC, "name");
        Sort.Order desc = new Sort.Order(Sort.Direction.DESC, "desc");
        Page<Product> allProducts = productRepository.findAll(PageRequest.of(0, 3,Sort.by(name,desc)));
        allProducts.forEach(product -> System.out.println(product));

    }


    @Test
    public void testPagingonCustomFider()
    {

        List<Product> byDescLike = productRepository.findByDescLike("%bu%", PageRequest.of(0, 3, Sort.by(new Sort.Order(Sort.Direction.ASC, "name"))));
        byDescLike.forEach(product -> System.out.println("RESULT>>>>>>>>>>>>>>>>>>>>>>"+product));

    }
}
