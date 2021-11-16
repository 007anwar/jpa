package com.example.jpa;

import com.example.jpa.entity.Product;
import com.example.jpa.repo.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
void createProducts()
{
	for(int i=0;i<500;i++)
		this.testCrud(i);
}

	void testCrud(int id)
	{
		Product product = new Product();
		product.setId(id);
		product.setName("mac mini");
		product.setDesc("buget");
		product.setPrice(1000.00);
		this.createProduct(product);
	//	product.setName("Updated product");
	//	this.updateProduct(product);
	//	this.readProduct(id);
	//	this.testDelete(4);
	}



	void createProduct(Product product)
	{
		Product save = productRepository.save(product);
		System.out.println("Saved produect : "+save);
	}

	void readProduct(int id)
	{
		Optional<Product> optionalProduct = productRepository.findById(id);
		Product product = optionalProduct.orElseThrow(() -> new RuntimeException(""));
		assertEquals("Updated product",product.getName());
	}

	void updateProduct(Product product)
	{
		int id= product.getId();
		Optional<Product> byId = productRepository.findById(id);
		byId.orElseThrow(()->new RuntimeException("product not found with id : "+id));
		byId.ifPresent(pr -> {
			pr.setName(product.getName());
			Product updatedProduct = productRepository.save(pr);
			System.out.println("Updated product is : "+updatedProduct);
		});
	}

	void updateProductException()
	{
		int id=4;
		Optional<Product> byId = productRepository.findById(id);
		byId.orElseThrow(()->new RuntimeException("product not found with id : "+id));
		byId.ifPresent(product -> {
			product.setName("updated product");
			Product updatedProduct = productRepository.save(product);
			System.out.println("Updated product is : "+updatedProduct);
		});
	//	assertThrows(RuntimeException.class,()->this.updateProductException());
	}
//	@Test
//	void checkException()
//	{
//		assertThrows(RuntimeException.class,this::updateProductException);
//	}

	void testDelete(int id)
	 {
		 boolean b = productRepository.existsById(id);
		 productRepository.deleteById(id);
	 }
	 @Test
	 void testCount()
	 {
		 System.out.println("Total records : "+productRepository.count());
	 }

}
