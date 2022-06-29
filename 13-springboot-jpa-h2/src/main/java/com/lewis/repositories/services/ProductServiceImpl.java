package com.lewis.repositories.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lewis.entities.Product;
import com.lewis.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repositoryP)
	{
		this.repository = repositoryP;
	}
	
	
	
	public List<Product> findAll(int pageNumber, int pageSize)
	{
		Pageable paging = PageRequest.of(pageNumber, pageSize);
		Page<Product> products = repository.findAll(paging);
		
		
	//List<Product> products = repository.findAll();
		
		return products.toList();
	}


	public Product findById(Long id) {
		 
		
	
		Product productId =  repository.findById(id).get();
		
		return productId;
		
	}


	public void addProduct(Product tempProduct) {
		 
		
		
		
		repository.save(tempProduct);
		
		
		
	}


	public void updateProduct(Long id, Product updatedProduct) {
		 
		
		Product product = this.findById(id);
		
		
		
	    RestrictedUpdateProduct(product, updatedProduct );
	    
	   repository.save(product);
		
	}
	

	public void deleteProduct(Long id) {
		 
		
	
		 
		 repository.deleteById(id);
		
	}


	private void RestrictedUpdateProduct(Product product, Product updatedProduct) {
	 
		
		 product.setName(updatedProduct.getName());
		 product.setPrice(updatedProduct.getPrice());
		 product.setDescription(updatedProduct.getDescription());

	}



	@Override
	public List<Product> findByNameContaining(String name) {
		
		
		
		
		var cities = (List<Product>) repository.findByName(name);
        return cities;
		
	}




}
