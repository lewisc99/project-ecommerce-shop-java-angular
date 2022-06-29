package com.lewis.entities.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lewis.entities.Category;
import com.lewis.entities.ProductCategory;
import com.lewis.repositories.services.CategoryService;
import com.lewis.repositories.services.CategoryServiceImpl;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("http://localhost:4200/")
public class CategoryController {
	
	
	@Autowired
	private CategoryService service;
	
	
	
	@GetMapping()
	public ResponseEntity<List<ProductCategory>> findAll()
	{
		List<ProductCategory> categories = service.findAll();
		
		return ResponseEntity.ok().body(categories);
		
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<ProductCategory> findById(@PathVariable Long id)
	{
		ProductCategory categoryId = service.findById(id);
		
		
		return ResponseEntity.ok().body(categoryId);
		
	}
	
	
	

}
