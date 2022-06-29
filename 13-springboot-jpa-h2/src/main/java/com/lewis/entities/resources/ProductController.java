package com.lewis.entities.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lewis.entities.Product;
import com.lewis.repositories.services.ProductService;
import com.lewis.repositories.services.ProductServiceImpl;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:4200/")
public class ProductController {
	
	
	@Autowired
	private ProductService service;
	
	
	public ProductController(ProductService serviceProduct)
	{
		service = serviceProduct;
	}

	
	
	@GetMapping("{pageNumber}/{pageSize}")
	public ResponseEntity<List<Product>> findAll(@PathVariable int pageNumber, @PathVariable int pageSize)
	{
		
		 List<Product> products = service.findAll(pageNumber,pageSize);
		 
		 
		 return ResponseEntity.ok().body(products);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id)
	{
		
		Product productId = service.findById(id);
		
		
		return ResponseEntity.ok().body(productId);
	}
	
	
	
	@PostMapping()
	private ResponseEntity<Void> newProduct(@RequestBody Product tempProduct)
	{
		
		service.addProduct(tempProduct);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
	@PutMapping("{id}")
	private ResponseEntity<Void> updateProduct(@PathVariable Long id, @RequestBody Product product)
	{
		
		Product productId = service.findById(id);
		
		if (productId == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		service.updateProduct(id,product);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("{id}")
	private ResponseEntity<Void> deleteProduct(@PathVariable Long id)
	{
		Product productId = service.findById(id);
		
		if (productId == null)
		{
			return ResponseEntity.notFound().build();
		}
		
		service.deleteProduct(id);
		
	return	ResponseEntity.noContent().build();
	}
	
	
	@GetMapping("/search")
	public ResponseEntity<List<Product>> findProductByName(@RequestParam("name") String name)
	{
		
		
		List<Product> products = service.findByNameContaining(name);
		
		return  ResponseEntity.ok().body(products);
	}
	
	
	
}
