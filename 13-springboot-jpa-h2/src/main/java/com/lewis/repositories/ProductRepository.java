package com.lewis.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.lewis.entities.Product;


@Repository

public interface ProductRepository extends JpaRepository<Product,Long> {
	
// Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable page);

	 @Query("select c from Product c where c.name like %:chars%")
	List<Product> findByName(String chars);
	
	
	   

}
