package com.example.jpa;

import com.example.jpa.entity.Product;
import com.example.jpa.repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaApplicationTests {
	private final ProductRepository productRepository;

	@Autowired
	public JpaApplicationTests(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void createProduct()
	{
		Product product = new Product();
		product.setId(4);
		product.setName("mac mini");
		product.setDesc("buget");
		product.setPrice(1000.00);
		Product save = productRepository.save(product);
		System.out.println("Saved produect : "+save);
	}

}
