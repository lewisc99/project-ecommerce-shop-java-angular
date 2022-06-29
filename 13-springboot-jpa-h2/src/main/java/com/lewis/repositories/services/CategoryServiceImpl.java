package com.lewis.repositories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lewis.entities.Category;
import com.lewis.entities.ProductCategory;
import com.lewis.repositories.CategoryRepository;
import com.lewis.repositories.ProductCategoryRepository;

@Service
public class CategoryServiceImpl  implements CategoryService{
	
	@Autowired
	private ProductCategoryRepository repository;

	public CategoryServiceImpl(ProductCategoryRepository categoryRepository)
	{
		repository = categoryRepository;
		
		
	}
	
	public List<ProductCategory> findAll()
	{
		
		List<ProductCategory> categories = repository.findAll();
		
		
		
		return categories;
	}

	public ProductCategory findById(Long id) {
		 
			
		return repository.findById(id).get();
		
		

	}
	
	
}
