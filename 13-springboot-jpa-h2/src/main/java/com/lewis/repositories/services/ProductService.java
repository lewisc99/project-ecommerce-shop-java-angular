package com.lewis.repositories.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.lewis.entities.Product;

public interface ProductService {

	
	
	public List<Product> findAll(int pageNumber, int pageSize);
	public Product findById(Long id);
	public void addProduct(Product tempProduct);
	public void updateProduct(Long id, Product updatedProduct);
	public void deleteProduct(Long id);
	public List<Product> findByNameContaining( String name);

}
