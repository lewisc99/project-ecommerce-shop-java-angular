package com.lewis.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lewis.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
	
// Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable page);

	 @Query("select c from Product c where c.name like %:chars%")
	List<Product> findByName(String chars);

}
