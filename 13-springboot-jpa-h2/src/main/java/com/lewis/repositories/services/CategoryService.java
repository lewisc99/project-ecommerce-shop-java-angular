package com.lewis.repositories.services;

import java.util.List;

import com.lewis.entities.Category;
import com.lewis.entities.ProductCategory;
import com.lewis.repositories.CategoryRepository;

public interface CategoryService {

	
		public List<ProductCategory> findAll();
	 

		public ProductCategory findById(Long id);
		


}
